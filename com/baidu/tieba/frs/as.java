package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.frs.loadmore.a;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class as implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity bQp;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void hP(int i) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        this.startTime = System.nanoTime();
        bmVar = this.bQp.bPo;
        if (bmVar != null) {
            switch (i) {
                case 1:
                    bmVar3 = this.bQp.bPo;
                    bmVar3.aby();
                    return;
                case 2:
                    bmVar2 = this.bQp.bPo;
                    bmVar2.aby();
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void a(int i, boolean z, e.a aVar) {
        bm bmVar;
        com.baidu.tieba.frs.i.y yVar;
        bm bmVar2;
        bm bmVar3;
        a aVar2;
        bm bmVar4;
        int i2;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        bm bmVar9;
        bm bmVar10;
        boolean z2;
        bm bmVar11;
        bm bmVar12;
        bm bmVar13;
        bm bmVar14;
        bm bmVar15;
        boolean z3;
        b bVar;
        com.baidu.tieba.tbadkCore.data.f fVar;
        bm bmVar16;
        com.baidu.tieba.frs.i.a aVar3;
        com.baidu.tieba.frs.i.a aVar4;
        com.baidu.tieba.frs.i.a aVar5;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        int i3;
        com.baidu.tieba.frs.i.aa aaVar;
        com.baidu.tieba.frs.i.aa aaVar2;
        a aVar6;
        com.baidu.tieba.frs.i.aa aaVar3;
        com.baidu.tieba.frs.i.aa aaVar4;
        int i4;
        int i5;
        b bVar2;
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        bm bmVar17;
        bm bmVar18;
        bm bmVar19;
        bm bmVar20;
        bm bmVar21;
        a aVar7;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        bm bmVar22;
        int i6;
        int i7;
        bm bmVar23;
        bm bmVar24;
        bm bmVar25;
        bm bmVar26;
        boolean z4;
        com.baidu.tieba.frs.i.y yVar2;
        boolean z5;
        bm bmVar27;
        bmVar = this.bQp.bPo;
        if (bmVar.abu() != null) {
            z5 = this.bQp.mIsLogin;
            if (z5) {
                bmVar27 = this.bQp.bPo;
                bmVar27.abu().setVisibility(0);
            }
        }
        yVar = this.bQp.bPE;
        if (yVar != null) {
            z4 = this.bQp.mIsLogin;
            if (z4) {
                yVar2 = this.bQp.bPE;
                yVar2.dW(true);
            }
        }
        bmVar2 = this.bQp.bPo;
        if (bmVar2.abo() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar26 = this.bQp.bPo;
            ((com.baidu.tieba.frs.tab.h) bmVar26.abo()).afa();
        }
        bmVar3 = this.bQp.bPo;
        bmVar3.abE();
        this.bQp.bPV = true;
        if (aVar != null && aVar.isSuccess) {
            bmVar25 = this.bQp.bPo;
            bmVar25.abJ().dT(com.baidu.tbadk.core.util.bb.vk().vm());
            FrsActivity.bPu = 0L;
            FrsActivity.bPv = 0L;
            FrsActivity.bPw = 0;
        } else {
            FrsActivity.bPw = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bQp.bPK;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bQp.aaV().adV() != null) {
            this.bQp.bPq = this.bQp.aaV().adV();
        }
        if (i != 7) {
            bmVar4 = this.bQp.bPo;
            bmVar4.dH(false);
            this.bQp.bPL = this.bQp.bPq.getPage().qq();
            i2 = this.bQp.bPL;
            if (i2 != 0 || (this.bQp.bPq.bhk() != null && this.bQp.bPq.bhk().size() != 0)) {
                bmVar5 = this.bQp.bPo;
                bmVar5.abN();
            } else if (this.bQp.bPq.getThreadList() == null || this.bQp.bPq.getThreadList().size() == 0) {
                bmVar23 = this.bQp.bPo;
                bmVar23.abP();
            } else {
                bmVar24 = this.bQp.bPo;
                bmVar24.abO();
            }
            if (i != 4) {
                switch (i) {
                    case 1:
                        bmVar7 = this.bQp.bPo;
                        bmVar7.aby();
                        break;
                    case 2:
                        bmVar6 = this.bQp.bPo;
                        bmVar6.aby();
                        break;
                    case 3:
                    case 6:
                        if (this.bQp.bPq != null) {
                            this.bQp.bPq.bhO();
                            break;
                        }
                        break;
                }
                FrsActivity frsActivity = this.bQp;
                bmVar8 = this.bQp.bPo;
                frsActivity.hideLoadingView(bmVar8.getRootView());
                bmVar9 = this.bQp.bPo;
                bmVar9.dI(false);
                if (this.bQp.bPq == null) {
                    bmVar10 = this.bQp.bPo;
                    bmVar10.abI();
                } else if (this.bQp.bPq.aLP() == null || this.bQp.bPq.aLP().getYuleData() == null || !this.bQp.bPq.aLP().getYuleData().sP()) {
                    bmVar20 = this.bQp.bPo;
                    bmVar20.abI();
                } else {
                    TiebaStatic.log("c10852");
                    bmVar21 = this.bQp.bPo;
                    bmVar21.a(this.bQp.bPq.aLP().getYuleData().sQ());
                }
                if (z || (aVar != null && aVar.errorCode != 0)) {
                    z2 = this.bQp.bOZ;
                    if (!z2) {
                        if (aVar != null) {
                            if (aVar.fpA) {
                                if (340001 == aVar.errorCode) {
                                    FrsActivity frsActivity2 = this.bQp;
                                    bmVar14 = this.bQp.bPo;
                                    frsActivity2.showNetRefreshViewNoClick(bmVar14.getRootView(), this.bQp.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                } else {
                                    FrsActivity frsActivity3 = this.bQp;
                                    bmVar13 = this.bQp.bPo;
                                    frsActivity3.showNetRefreshView(bmVar13.getRootView(), this.bQp.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                }
                            } else if (340001 == aVar.errorCode) {
                                FrsActivity frsActivity4 = this.bQp;
                                bmVar12 = this.bQp.bPo;
                                frsActivity4.showNetRefreshViewNoClick(bmVar12.getRootView(), aVar.errorMsg, true);
                            } else {
                                FrsActivity frsActivity5 = this.bQp;
                                bmVar11 = this.bQp.bPo;
                                frsActivity5.showNetRefreshView(bmVar11.getRootView(), aVar.errorMsg, true);
                            }
                            this.bQp.setNetRefreshViewEmotionDefMarginTop();
                        }
                    } else if (aVar != null && aVar.fpA) {
                        this.bQp.showToast(this.bQp.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                    }
                } else {
                    this.bQp.bOZ = true;
                    this.bQp.bPn = true;
                    if (this.bQp.bPq != null) {
                        this.bQp.bPf = this.bQp.bPq.aLP().getName();
                        this.bQp.forumId = this.bQp.bPq.aLP().getId();
                    }
                    z3 = this.bQp.bPA;
                    if (z3 && this.bQp.bPq != null && this.bQp.bPB.aeM() == 1) {
                        this.bQp.bPq.bhR();
                        bmVar18 = this.bQp.bPo;
                        if (bmVar18.abJ().k(com.baidu.tieba.tbadkCore.al.frw)) {
                            this.bQp.bPq.bhS();
                        }
                        if (!this.bQp.bPB.aeS()) {
                            this.bQp.bPq.bhY();
                        }
                        if (!this.bQp.aaV().aeJ()) {
                            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && !this.bQp.bPB.aeS()) {
                                this.bQp.bPq.bhX();
                                this.bQp.bPq.bhW();
                                this.bQp.bPq.bhU();
                            }
                            if (!this.bQp.bPB.aeS()) {
                                this.bQp.bPq.bhV();
                            }
                        }
                        boolean z6 = false;
                        bmVar19 = this.bQp.bPo;
                        if (bmVar19.abJ().k(com.baidu.tieba.card.data.q.bci) && !this.bQp.bPB.aeS()) {
                            z6 = this.bQp.bPq.bib();
                        }
                        if (!z6 && !this.bQp.bPB.aeS()) {
                            this.bQp.bPq.bia();
                        }
                        if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                            this.bQp.bPq.bf(this.bQp.getPageContext().getPageActivity());
                        }
                    }
                    if (this.bQp.bPq != null) {
                        this.bQp.bPq.bhQ();
                        com.baidu.tbadk.core.data.bl top_notice_data = this.bQp.bPq.aLP().getTop_notice_data();
                        if (top_notice_data != null && top_notice_data.getTitle() != null) {
                            com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
                            bgVar.setTitle(top_notice_data.getTitle());
                            bgVar.bV(2);
                            bgVar.cs(top_notice_data.sJ());
                            bgVar.si();
                            this.bQp.bPq.v(bgVar);
                        }
                        this.bQp.bPq.bic();
                    }
                    this.bQp.aaw();
                    if (this.bQp.bPq.bie()) {
                        dVar2 = this.bQp.bPG;
                        bmVar17 = this.bQp.bPo;
                        dVar2.a(bmVar17.getListView(), this.bQp.bPq, this.bQp.bPB.aeU());
                    }
                    bVar = this.bQp.bPM;
                    if (bVar != null) {
                        bVar2 = this.bQp.bPM;
                        pVar = this.bQp.bPC;
                        bVar2.a(pVar, this.bQp.bPq);
                    }
                    FrsActivity.bPu = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsActivity.bPv = aVar.fpB;
                    }
                    if (this.bQp.bPq == null || this.bQp.bPq.getThreadList() == null || this.bQp.bPq.getThreadList().size() != 0 || this.bQp.aaV().getType() != 4) {
                        if (this.bQp.bPq != null) {
                            if (this.bQp.bPq.aLP() != null) {
                                aaVar4 = this.bQp.bPD;
                                aaVar4.eh(this.bQp.bPq.aLP().isLike() == 1);
                            }
                            if (this.bQp.bPq.aLP().isIs_forbidden() == 1) {
                                aaVar3 = this.bQp.bPD;
                                aaVar3.ej(false);
                            } else {
                                aaVar = this.bQp.bPD;
                                aaVar.ej(true);
                            }
                            aaVar2 = this.bQp.bPD;
                            aaVar2.ei(this.bQp.bPq.bhd() == 1);
                            aVar6 = this.bQp.bPK;
                            ArrayList<com.baidu.adp.widget.ListView.v> a = aVar6.a(true, this.bQp.bPq.getThreadList());
                            if (a != null) {
                                this.bQp.bPq.aA(a);
                            }
                        }
                        if (this.bQp.bPB.aeM() == 1) {
                            this.bQp.aaF();
                        }
                        if (this.bQp.bPq != null) {
                            this.bQp.bPi = this.bQp.bPq.aeO();
                        }
                        fVar = this.bQp.bPk;
                        if (fVar != null) {
                            this.bQp.bPj = false;
                            fVar2 = this.bQp.bPk;
                            i3 = this.bQp.bPi;
                            fVar2.ru(i3);
                        }
                        bmVar16 = this.bQp.bPo;
                        bmVar16.hS(i);
                        aVar3 = this.bQp.bPP;
                        if (aVar3 != null) {
                            aVar4 = this.bQp.bPP;
                            aVar4.ef(this.bQp.bPB.aeS());
                            aVar5 = this.bQp.bPP;
                            dVar = this.bQp.bPG;
                            aVar5.ai(dVar.adi());
                        }
                    } else {
                        this.bQp.showToast(this.bQp.getPageContext().getString(t.j.no_more_to_load));
                        i4 = this.bQp.mPn;
                        if (i4 > 1) {
                            FrsActivity frsActivity6 = this.bQp;
                            i5 = frsActivity6.mPn;
                            frsActivity6.mPn = i5 - 1;
                        }
                        if (this.bQp.bGO > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bQp.bGO, this.bQp.aaV().XM() - this.bQp.bGO, this.bQp.aaV().XK(), this.bQp.aaV().XL(), currentTimeMillis2 - this.bQp.aaV().XJ());
                            this.bQp.bGO = -1L;
                        }
                        this.bQp.aCr = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.bQp.bPq.bhe() == 1) {
                    if (!this.bQp.bPB.aeS()) {
                        bmVar15 = this.bQp.bPo;
                        bmVar15.abZ();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11384"));
                }
                if (this.bQp.bGO > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bQp.bGO, this.bQp.aaV().XM() - this.bQp.bGO, this.bQp.aaV().XK(), this.bQp.aaV().XL(), currentTimeMillis3 - this.bQp.aaV().XJ());
                    this.bQp.bGO = -1L;
                }
                this.bQp.aCr = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                this.bQp.bPq.bf(this.bQp.getPageContext().getPageActivity());
            }
            aVar7 = this.bQp.bPK;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bQp.bPq.getThreadList();
            fVar3 = this.bQp.bPk;
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = aVar7.a(false, threadList, fVar3);
            if (a2 != null) {
                this.bQp.bPq.aA(a2);
                this.bQp.bPq.bhQ();
                bmVar22 = this.bQp.bPo;
                i6 = this.bQp.mPn;
                com.baidu.tieba.tbadkCore.p pVar2 = this.bQp.bPq;
                i7 = this.bQp.bPL;
                bmVar22.a(a2, i6, pVar2, i7);
            }
            if (this.bQp.aaV() != null) {
                com.baidu.tieba.frs.g.b.a(this.bQp.bPq, this.bQp.aaV().acf(), 2);
                return;
            }
            return;
        }
        this.bQp.hL(this.bQp.bPq.bhz());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if (!"normal_page".equals(this.bQp.aaV().aeH()) && !"frs_page".equals(this.bQp.aaV().aeH()) && !"book_page".equals(this.bQp.aaV().aeH())) {
                return;
            }
            this.bQp.a(nVar);
        }
    }
}
