package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class av implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity blk;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void gG(int i) {
        this.startTime = System.nanoTime();
        if (this.blk.bko != null) {
            switch (i) {
                case 1:
                    this.blk.bko.cF(true);
                    this.blk.bko.RP();
                    return;
                case 2:
                    this.blk.bko.cG(true);
                    this.blk.bko.RP();
                    return;
                case 3:
                case 6:
                    this.blk.bko.cE(true);
                    return;
                case 4:
                case 5:
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d4, code lost:
        if (r1.aRJ().size() == 0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01fd  */
    @Override // com.baidu.tieba.tbadkCore.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, d.a aVar) {
        com.baidu.tieba.frs.loadmore.a aVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        int i2;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        boolean z2;
        com.baidu.tieba.tbadkCore.o oVar5;
        boolean z3;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.frs.c.a aVar3;
        com.baidu.tieba.tbadkCore.o oVar8;
        com.baidu.tieba.tbadkCore.o oVar9;
        com.baidu.tieba.tbadkCore.o oVar10;
        com.baidu.tieba.frs.c.l lVar;
        com.baidu.tieba.tbadkCore.o oVar11;
        com.baidu.tieba.frs.loadmore.a aVar4;
        com.baidu.tieba.tbadkCore.o oVar12;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.tbadkCore.o oVar13;
        com.baidu.tieba.tbadkCore.data.f fVar;
        com.baidu.tieba.frs.c.a aVar5;
        com.baidu.tieba.tbadkCore.o oVar14;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        int i3;
        com.baidu.tieba.tbadkCore.o oVar15;
        com.baidu.tieba.tbadkCore.o oVar16;
        com.baidu.tieba.frs.c.l lVar2;
        com.baidu.tieba.tbadkCore.o oVar17;
        com.baidu.tieba.tbadkCore.o oVar18;
        com.baidu.tieba.tbadkCore.o oVar19;
        com.baidu.tieba.frs.c.l lVar3;
        com.baidu.tieba.tbadkCore.o oVar20;
        com.baidu.tieba.tbadkCore.o oVar21;
        com.baidu.tieba.tbadkCore.o oVar22;
        com.baidu.tieba.tbadkCore.o oVar23;
        com.baidu.tieba.tbadkCore.o oVar24;
        com.baidu.tieba.tbadkCore.o oVar25;
        com.baidu.tieba.tbadkCore.o oVar26;
        com.baidu.tieba.tbadkCore.o oVar27;
        com.baidu.tieba.tbadkCore.o oVar28;
        com.baidu.tieba.tbadkCore.o oVar29;
        com.baidu.tieba.tbadkCore.o oVar30;
        com.baidu.tieba.tbadkCore.o oVar31;
        com.baidu.tieba.tbadkCore.o oVar32;
        com.baidu.tieba.tbadkCore.o oVar33;
        com.baidu.tieba.tbadkCore.o oVar34;
        com.baidu.tieba.tbadkCore.o oVar35;
        com.baidu.tieba.tbadkCore.o oVar36;
        com.baidu.tieba.tbadkCore.o oVar37;
        com.baidu.tieba.tbadkCore.o oVar38;
        com.baidu.tieba.tbadkCore.o oVar39;
        com.baidu.tieba.frs.c.a aVar6;
        com.baidu.tieba.tbadkCore.o oVar40;
        com.baidu.tieba.tbadkCore.o oVar41;
        com.baidu.tieba.tbadkCore.o oVar42;
        com.baidu.tieba.tbadkCore.o oVar43;
        com.baidu.tieba.tbadkCore.o oVar44;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.o oVar45;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        com.baidu.tieba.tbadkCore.o oVar46;
        com.baidu.tieba.tbadkCore.o oVar47;
        com.baidu.tieba.tbadkCore.o oVar48;
        int i4;
        com.baidu.tieba.tbadkCore.o oVar49;
        com.baidu.tieba.tbadkCore.o oVar50;
        String str;
        com.baidu.tieba.tbadkCore.o oVar51;
        com.baidu.tieba.tbadkCore.o oVar52;
        com.baidu.tieba.tbadkCore.o oVar53;
        com.baidu.tieba.tbadkCore.o oVar54;
        com.baidu.tieba.tbadkCore.o oVar55;
        int i5;
        com.baidu.tieba.tbadkCore.o oVar56;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar57;
        com.baidu.tieba.tbadkCore.o oVar58;
        this.blk.bkO = true;
        if (aVar != null && aVar.isSuccess) {
            this.blk.bko.Sb().cw(com.baidu.tbadk.core.util.az.wz().wB());
            FrsActivity.bku = 0L;
            FrsActivity.bkv = 0L;
            FrsActivity.bkw = 0;
        } else {
            FrsActivity.bkw = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.blk.bkG;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.blk.Rd().SP() != null) {
            this.blk.bkq = this.blk.Rd().SP();
        }
        if (i != 7) {
            this.blk.bko.cE(false);
            FrsActivity frsActivity = this.blk;
            oVar = this.blk.bkq;
            frsActivity.bkH = oVar.getPage().sq();
            i2 = this.blk.bkH;
            if (i2 == 0) {
                oVar53 = this.blk.bkq;
                if (oVar53.aRJ() != null) {
                    oVar57 = this.blk.bkq;
                }
                oVar54 = this.blk.bkq;
                if (oVar54.getThreadList() != null) {
                    oVar55 = this.blk.bkq;
                    if (oVar55.getThreadList().size() != 0) {
                        cs csVar = this.blk.bko;
                        i5 = FrsActivity.bjX;
                        oVar56 = this.blk.bkq;
                        int size = oVar56.getThreadList().size();
                        i6 = FrsActivity.bjY;
                        csVar.gP(i5 - (size * i6));
                        this.blk.bko.Sh();
                        if (i != 4) {
                            switch (i) {
                                case 1:
                                    this.blk.bko.cF(false);
                                    this.blk.bko.RP();
                                    break;
                                case 2:
                                    this.blk.bko.cG(false);
                                    this.blk.bko.RP();
                                    break;
                                case 3:
                                case 6:
                                    oVar2 = this.blk.bkq;
                                    if (oVar2 != null) {
                                        oVar3 = this.blk.bkq;
                                        oVar3.aSg();
                                        break;
                                    }
                                    break;
                            }
                            this.blk.hideLoadingView(this.blk.bko.getRootView());
                            this.blk.bko.RW();
                            oVar4 = this.blk.bkq;
                            if (oVar4 == null) {
                                this.blk.bko.Sa();
                            } else {
                                oVar41 = this.blk.bkq;
                                if (oVar41.avu() != null) {
                                    oVar42 = this.blk.bkq;
                                    if (oVar42.avu().getYuleData() != null) {
                                        oVar43 = this.blk.bkq;
                                        if (oVar43.avu().getYuleData().ui()) {
                                            TiebaStatic.log("c10852");
                                            cs csVar2 = this.blk.bko;
                                            oVar44 = this.blk.bkq;
                                            csVar2.a(oVar44.avu().getYuleData().uj());
                                        }
                                    }
                                }
                                this.blk.bko.Sa();
                            }
                            if (z || (aVar != null && aVar.errorCode != 0)) {
                                z2 = this.blk.bka;
                                if (!z2) {
                                    if (aVar != null) {
                                        if (aVar.emO) {
                                            if (340001 == aVar.errorCode) {
                                                this.blk.showNetRefreshViewNoClick(this.blk.bko.getRootView(), this.blk.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                            } else {
                                                this.blk.showNetRefreshView(this.blk.bko.getRootView(), this.blk.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                            }
                                        } else if (340001 == aVar.errorCode) {
                                            this.blk.showNetRefreshViewNoClick(this.blk.bko.getRootView(), aVar.errorMsg, true);
                                        } else {
                                            this.blk.showNetRefreshView(this.blk.bko.getRootView(), aVar.errorMsg, true);
                                        }
                                        this.blk.bko.gO(8);
                                    }
                                } else if (aVar != null && aVar.emO) {
                                    this.blk.bko.gO(0);
                                    this.blk.showToast(this.blk.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                                }
                            } else {
                                this.blk.bka = true;
                                this.blk.bkn = true;
                                this.blk.bko.gO(0);
                                oVar5 = this.blk.bkq;
                                if (oVar5 != null) {
                                    FrsActivity frsActivity2 = this.blk;
                                    oVar35 = this.blk.bkq;
                                    frsActivity2.bkf = oVar35.avu().getName();
                                    FrsActivity frsActivity3 = this.blk;
                                    oVar36 = this.blk.bkq;
                                    frsActivity3.forumId = oVar36.avu().getId();
                                    oVar37 = this.blk.bkq;
                                    if (oVar37.avu().getFrsBannerData().getType() == 2) {
                                        aVar6 = this.blk.bkD;
                                        oVar40 = this.blk.bkq;
                                        aVar6.hk(oVar40.getUserData().getIsMem());
                                    }
                                    cs csVar3 = this.blk.bko;
                                    oVar38 = this.blk.bkq;
                                    ForumData avu = oVar38.avu();
                                    oVar39 = this.blk.bkq;
                                    csVar3.a(avu, oVar39.getUserData(), 1);
                                }
                                z3 = this.blk.bkA;
                                if (z3) {
                                    oVar24 = this.blk.bkq;
                                    if (oVar24 != null && this.blk.bkB.Tk() == 1) {
                                        oVar25 = this.blk.bkq;
                                        oVar25.aSk();
                                        oVar26 = this.blk.bkq;
                                        oVar26.aSq();
                                        if (!this.blk.Rd().Tg()) {
                                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                                oVar32 = this.blk.bkq;
                                                oVar32.aSp();
                                                oVar33 = this.blk.bkq;
                                                oVar33.aSo();
                                                oVar34 = this.blk.bkq;
                                                oVar34.aSm();
                                            }
                                            oVar31 = this.blk.bkq;
                                            oVar31.aSn();
                                        }
                                        oVar27 = this.blk.bkq;
                                        if (!oVar27.aSt()) {
                                            oVar30 = this.blk.bkq;
                                            oVar30.aSs();
                                        }
                                        if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                            oVar28 = this.blk.bkq;
                                            oVar28.aK(this.blk.getPageContext().getPageActivity());
                                            oVar29 = this.blk.bkq;
                                            oVar29.N(this.blk.getPageContext().getPageActivity(), this.blk.forumId);
                                        }
                                    }
                                }
                                oVar6 = this.blk.bkq;
                                if (oVar6 != null) {
                                    oVar23 = this.blk.bkq;
                                    oVar23.aSj();
                                }
                                oVar7 = this.blk.bkq;
                                com.baidu.tbadk.core.data.au top_notice_data = oVar7.avu().getTop_notice_data();
                                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                    com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
                                    asVar.setTitle(top_notice_data.getTitle());
                                    asVar.bW(2);
                                    asVar.cu(top_notice_data.uc());
                                    asVar.parser_title();
                                    oVar22 = this.blk.bkq;
                                    oVar22.k(asVar);
                                }
                                aVar3 = this.blk.bkD;
                                String Tf = this.blk.Rd().Tf();
                                oVar8 = this.blk.bkq;
                                aVar3.a(Tf, oVar8);
                                FrsActivity.bku = (System.nanoTime() - this.startTime) / 1000000;
                                if (aVar != null) {
                                    FrsActivity.bkv = aVar.emP;
                                }
                                oVar9 = this.blk.bkq;
                                if (oVar9 != null) {
                                    oVar20 = this.blk.bkq;
                                    if (oVar20.getThreadList() != null) {
                                        oVar21 = this.blk.bkq;
                                        if (oVar21.getThreadList().size() == 0 && this.blk.Rd().getType() == 4) {
                                            this.blk.showToast(this.blk.getPageContext().getString(t.j.no_more_to_load));
                                            if (this.blk.mPn > 1) {
                                                FrsActivity frsActivity4 = this.blk;
                                                frsActivity4.mPn--;
                                            }
                                            if (this.blk.bbg > -1) {
                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.blk.bbg, this.blk.Rd().Oc() - this.blk.bbg, this.blk.Rd().Oa(), this.blk.Rd().Ob(), currentTimeMillis2 - this.blk.Rd().NZ());
                                                this.blk.bbg = -1L;
                                            }
                                            this.blk.aBB = System.currentTimeMillis() - currentTimeMillis;
                                            return;
                                        }
                                    }
                                }
                                oVar10 = this.blk.bkq;
                                if (oVar10 != null) {
                                    oVar18 = this.blk.bkq;
                                    if (oVar18.getUserData() != null) {
                                        oVar19 = this.blk.bkq;
                                        if (oVar19.getUserData().isBawu()) {
                                            lVar3 = this.blk.bkE;
                                            lVar3.setIsManager(true);
                                            oVar11 = this.blk.bkq;
                                            if (oVar11 != null) {
                                                oVar16 = this.blk.bkq;
                                                if (oVar16.avu() != null) {
                                                    lVar2 = this.blk.bkE;
                                                    oVar17 = this.blk.bkq;
                                                    lVar2.cN(oVar17.avu().isLike() == 1);
                                                }
                                            }
                                            aVar4 = this.blk.bkG;
                                            oVar12 = this.blk.bkq;
                                            a = aVar4.a(true, oVar12.getThreadList());
                                            if (a != null) {
                                                oVar15 = this.blk.bkq;
                                                oVar15.ao(a);
                                            }
                                            this.blk.QP();
                                            FrsActivity frsActivity5 = this.blk;
                                            oVar13 = this.blk.bkq;
                                            frsActivity5.bkj = oVar13.To();
                                            fVar = this.blk.bkl;
                                            if (fVar != null) {
                                                this.blk.bkk = false;
                                                fVar2 = this.blk.bkl;
                                                i3 = this.blk.bkj;
                                                fVar2.pn(i3);
                                            }
                                            aVar5 = this.blk.bkD;
                                            oVar14 = this.blk.bkq;
                                            aVar5.cL(oVar14.aRG());
                                            this.blk.bko.gQ(i);
                                        }
                                    }
                                }
                                lVar = this.blk.bkE;
                                lVar.setIsManager(false);
                                oVar11 = this.blk.bkq;
                                if (oVar11 != null) {
                                }
                                aVar4 = this.blk.bkG;
                                oVar12 = this.blk.bkq;
                                a = aVar4.a(true, oVar12.getThreadList());
                                if (a != null) {
                                }
                                this.blk.QP();
                                FrsActivity frsActivity52 = this.blk;
                                oVar13 = this.blk.bkq;
                                frsActivity52.bkj = oVar13.To();
                                fVar = this.blk.bkl;
                                if (fVar != null) {
                                }
                                aVar5 = this.blk.bkD;
                                oVar14 = this.blk.bkq;
                                aVar5.cL(oVar14.aRG());
                                this.blk.bko.gQ(i);
                            }
                            if (this.blk.bbg > -1) {
                                long currentTimeMillis3 = System.currentTimeMillis();
                                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.blk.bbg, this.blk.Rd().Oc() - this.blk.bbg, this.blk.Rd().Oa(), this.blk.Rd().Ob(), currentTimeMillis3 - this.blk.Rd().NZ());
                                this.blk.bbg = -1L;
                            }
                            this.blk.aBB = System.currentTimeMillis() - currentTimeMillis;
                            System.gc();
                            return;
                        }
                        if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                            oVar49 = this.blk.bkq;
                            oVar49.aK(this.blk.getPageContext().getPageActivity());
                            oVar50 = this.blk.bkq;
                            if (oVar50.avu() != null) {
                                oVar52 = this.blk.bkq;
                                str = oVar52.avu().getId();
                            } else {
                                str = "";
                            }
                            oVar51 = this.blk.bkq;
                            oVar51.N(this.blk.getPageContext().getPageActivity(), str);
                        }
                        aVar7 = this.blk.bkG;
                        oVar45 = this.blk.bkq;
                        ArrayList<com.baidu.adp.widget.ListView.u> threadList = oVar45.getThreadList();
                        fVar3 = this.blk.bkl;
                        ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, threadList, fVar3);
                        if (a2 != null) {
                            oVar46 = this.blk.bkq;
                            oVar46.ao(a2);
                            oVar47 = this.blk.bkq;
                            oVar47.aSj();
                            cs csVar4 = this.blk.bko;
                            int i7 = this.blk.mPn;
                            oVar48 = this.blk.bkq;
                            i4 = this.blk.bkH;
                            csVar4.a(a2, i7, oVar48, i4);
                            return;
                        }
                        return;
                    }
                }
                this.blk.bko.Si();
                if (i != 4) {
                }
            }
            this.blk.bko.Sg();
            if (i != 4) {
            }
        } else {
            oVar58 = this.blk.bkq;
            this.blk.gC(oVar58.aRY());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.blk.Rd().Tf()) && !"frs_page".equals(this.blk.Rd().Tf())) {
                return;
            }
            this.blk.a(mVar);
        }
    }
}
