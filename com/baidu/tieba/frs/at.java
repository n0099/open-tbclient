package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity bgz;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void gp(int i) {
        this.startTime = System.nanoTime();
        if (this.bgz.bfD != null) {
            switch (i) {
                case 1:
                    this.bgz.bfD.ct(true);
                    this.bgz.bfD.PW();
                    return;
                case 2:
                    this.bgz.bfD.cu(true);
                    this.bgz.bfD.PW();
                    return;
                case 3:
                case 6:
                    this.bgz.bfD.cs(true);
                    return;
                case 4:
                case 5:
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b7, code lost:
        if (r1.aKU().size() == 0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x07ba  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e4  */
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
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.frs.c.a aVar5;
        com.baidu.tieba.tbadkCore.o oVar14;
        com.baidu.tieba.tbadkCore.data.e eVar2;
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
        com.baidu.tieba.frs.c.a aVar6;
        com.baidu.tieba.tbadkCore.o oVar39;
        com.baidu.tieba.tbadkCore.o oVar40;
        com.baidu.tieba.tbadkCore.o oVar41;
        com.baidu.tieba.tbadkCore.o oVar42;
        com.baidu.tieba.tbadkCore.o oVar43;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.o oVar44;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        com.baidu.tieba.tbadkCore.o oVar45;
        com.baidu.tieba.tbadkCore.o oVar46;
        com.baidu.tieba.tbadkCore.o oVar47;
        int i4;
        com.baidu.tieba.tbadkCore.o oVar48;
        com.baidu.tieba.tbadkCore.o oVar49;
        String str;
        com.baidu.tieba.tbadkCore.o oVar50;
        com.baidu.tieba.tbadkCore.o oVar51;
        com.baidu.tieba.tbadkCore.o oVar52;
        com.baidu.tieba.tbadkCore.o oVar53;
        com.baidu.tieba.tbadkCore.o oVar54;
        int i5;
        com.baidu.tieba.tbadkCore.o oVar55;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar56;
        this.bgz.bgc = true;
        if (aVar != null && aVar.isSuccess) {
            this.bgz.bfD.Qi().ck(com.baidu.tbadk.core.util.ax.wg().wi());
            FrsActivity.bfJ = 0L;
            FrsActivity.bfK = 0L;
            FrsActivity.bfL = 0;
        } else {
            FrsActivity.bfL = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bgz.bfV;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.bgz.bfD.cs(false);
        if (this.bgz.Po().Rc() != null) {
            this.bgz.bfF = this.bgz.Po().Rc();
        }
        FrsActivity frsActivity = this.bgz;
        oVar = this.bgz.bfF;
        frsActivity.bfW = oVar.getPage().sv();
        i2 = this.bgz.bfW;
        if (i2 == 0) {
            oVar52 = this.bgz.bfF;
            if (oVar52.aKU() != null) {
                oVar56 = this.bgz.bfF;
            }
            oVar53 = this.bgz.bfF;
            if (oVar53.getThreadList() != null) {
                oVar54 = this.bgz.bfF;
                if (oVar54.getThreadList().size() != 0) {
                    cn cnVar = this.bgz.bfD;
                    i5 = FrsActivity.bfn;
                    oVar55 = this.bgz.bfF;
                    int size = oVar55.getThreadList().size();
                    i6 = FrsActivity.bfo;
                    cnVar.gy(i5 - (size * i6));
                    this.bgz.bfD.Qo();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                this.bgz.bfD.ct(false);
                                this.bgz.bfD.PW();
                                break;
                            case 2:
                                this.bgz.bfD.cu(false);
                                this.bgz.bfD.PW();
                                break;
                            case 3:
                            case 6:
                                oVar2 = this.bgz.bfF;
                                if (oVar2 != null) {
                                    oVar3 = this.bgz.bfF;
                                    oVar3.aLo();
                                    break;
                                }
                                break;
                        }
                        this.bgz.hideLoadingView(this.bgz.bfD.getRootView());
                        this.bgz.bfD.Qd();
                        oVar4 = this.bgz.bfF;
                        if (oVar4 == null) {
                            this.bgz.bfD.Qh();
                        } else {
                            oVar40 = this.bgz.bfF;
                            if (oVar40.aoE() != null) {
                                oVar41 = this.bgz.bfF;
                                if (oVar41.aoE().getYuleData() != null) {
                                    oVar42 = this.bgz.bfF;
                                    if (oVar42.aoE().getYuleData().uc()) {
                                        TiebaStatic.log("c10852");
                                        cn cnVar2 = this.bgz.bfD;
                                        oVar43 = this.bgz.bfF;
                                        cnVar2.a(oVar43.aoE().getYuleData().ud());
                                    }
                                }
                            }
                            this.bgz.bfD.Qh();
                        }
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.bgz.bfq;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.dUo) {
                                        if (340001 == aVar.errorCode) {
                                            this.bgz.showNetRefreshViewNoClick(this.bgz.bfD.getRootView(), this.bgz.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            this.bgz.showNetRefreshView(this.bgz.bfD.getRootView(), this.bgz.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        this.bgz.showNetRefreshViewNoClick(this.bgz.bfD.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        this.bgz.showNetRefreshView(this.bgz.bfD.getRootView(), aVar.errorMsg, true);
                                    }
                                    this.bgz.bfD.gx(8);
                                }
                            } else if (aVar != null && aVar.dUo) {
                                this.bgz.bfD.gx(0);
                                this.bgz.showToast(this.bgz.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.bgz.bfq = true;
                            this.bgz.bfC = true;
                            this.bgz.bfD.gx(0);
                            oVar5 = this.bgz.bfF;
                            if (oVar5 != null) {
                                FrsActivity frsActivity2 = this.bgz;
                                oVar34 = this.bgz.bfF;
                                frsActivity2.bfv = oVar34.aoE().getName();
                                FrsActivity frsActivity3 = this.bgz;
                                oVar35 = this.bgz.bfF;
                                frsActivity3.forumId = oVar35.aoE().getId();
                                oVar36 = this.bgz.bfF;
                                if (oVar36.aoE().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.bgz.bfS;
                                    oVar39 = this.bgz.bfF;
                                    aVar6.gR(oVar39.getUserData().getIsMem());
                                }
                                cn cnVar3 = this.bgz.bfD;
                                oVar37 = this.bgz.bfF;
                                ForumData aoE = oVar37.aoE();
                                oVar38 = this.bgz.bfF;
                                cnVar3.a(aoE, oVar38.getUserData(), 1);
                            }
                            z3 = this.bgz.bfP;
                            if (z3) {
                                oVar24 = this.bgz.bfF;
                                if (oVar24 != null && this.bgz.bfQ.Rx() == 1) {
                                    oVar25 = this.bgz.bfF;
                                    oVar25.aLs();
                                    oVar26 = this.bgz.bfF;
                                    oVar26.aLx();
                                    if (!this.bgz.Po().Rt() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                        oVar31 = this.bgz.bfF;
                                        oVar31.aLw();
                                        oVar32 = this.bgz.bfF;
                                        oVar32.aLv();
                                        oVar33 = this.bgz.bfF;
                                        oVar33.aLu();
                                    }
                                    oVar27 = this.bgz.bfF;
                                    if (!oVar27.aLA()) {
                                        oVar30 = this.bgz.bfF;
                                        oVar30.aLz();
                                    }
                                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                        oVar28 = this.bgz.bfF;
                                        oVar28.aQ(this.bgz.getPageContext().getPageActivity());
                                        oVar29 = this.bgz.bfF;
                                        oVar29.W(this.bgz.getPageContext().getPageActivity(), this.bgz.forumId);
                                    }
                                }
                            }
                            oVar6 = this.bgz.bfF;
                            if (oVar6 != null) {
                                oVar23 = this.bgz.bfF;
                                oVar23.aLr();
                            }
                            oVar7 = this.bgz.bfF;
                            com.baidu.tbadk.core.data.aj top_notice_data = oVar7.aoE().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                                ahVar.setTitle(top_notice_data.getTitle());
                                ahVar.bU(2);
                                ahVar.cw(top_notice_data.tW());
                                ahVar.parser_title();
                                oVar22 = this.bgz.bfF;
                                oVar22.j(ahVar);
                            }
                            aVar3 = this.bgz.bfS;
                            String Rs = this.bgz.Po().Rs();
                            oVar8 = this.bgz.bfF;
                            aVar3.a(Rs, oVar8);
                            FrsActivity.bfJ = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.bfK = aVar.dUp;
                            }
                            oVar9 = this.bgz.bfF;
                            if (oVar9 != null) {
                                oVar20 = this.bgz.bfF;
                                if (oVar20.getThreadList() != null) {
                                    oVar21 = this.bgz.bfF;
                                    if (oVar21.getThreadList().size() == 0 && this.bgz.Po().getType() == 4) {
                                        this.bgz.showToast(this.bgz.getPageContext().getString(t.j.no_more_to_load));
                                        if (this.bgz.mPn > 1) {
                                            FrsActivity frsActivity4 = this.bgz;
                                            frsActivity4.mPn--;
                                        }
                                        if (this.bgz.aWx > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bgz.aWx, this.bgz.Po().Mo() - this.bgz.aWx, this.bgz.Po().Mm(), this.bgz.Po().Mn(), currentTimeMillis2 - this.bgz.Po().Ml());
                                            this.bgz.aWx = -1L;
                                        }
                                        this.bgz.aAK = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            oVar10 = this.bgz.bfF;
                            if (oVar10 != null) {
                                oVar18 = this.bgz.bfF;
                                if (oVar18.getUserData() != null) {
                                    oVar19 = this.bgz.bfF;
                                    if (oVar19.getUserData().isBawu()) {
                                        lVar3 = this.bgz.bfT;
                                        lVar3.setIsManager(true);
                                        oVar11 = this.bgz.bfF;
                                        if (oVar11 != null) {
                                            oVar16 = this.bgz.bfF;
                                            if (oVar16.aoE() != null) {
                                                lVar2 = this.bgz.bfT;
                                                oVar17 = this.bgz.bfF;
                                                lVar2.cB(oVar17.aoE().isLike() == 1);
                                            }
                                        }
                                        aVar4 = this.bgz.bfV;
                                        oVar12 = this.bgz.bfF;
                                        a = aVar4.a(true, oVar12.getThreadList());
                                        if (a != null) {
                                            oVar15 = this.bgz.bfF;
                                            oVar15.an(a);
                                        }
                                        this.bgz.Pa();
                                        FrsActivity frsActivity5 = this.bgz;
                                        oVar13 = this.bgz.bfF;
                                        frsActivity5.bfz = oVar13.RA();
                                        eVar = this.bgz.bfA;
                                        if (eVar != null) {
                                            eVar2 = this.bgz.bfA;
                                            i3 = this.bgz.bfz;
                                            eVar2.oe(i3);
                                        }
                                        aVar5 = this.bgz.bfS;
                                        oVar14 = this.bgz.bfF;
                                        aVar5.cz(oVar14.aKR());
                                    }
                                }
                            }
                            lVar = this.bgz.bfT;
                            lVar.setIsManager(false);
                            oVar11 = this.bgz.bfF;
                            if (oVar11 != null) {
                            }
                            aVar4 = this.bgz.bfV;
                            oVar12 = this.bgz.bfF;
                            a = aVar4.a(true, oVar12.getThreadList());
                            if (a != null) {
                            }
                            this.bgz.Pa();
                            FrsActivity frsActivity52 = this.bgz;
                            oVar13 = this.bgz.bfF;
                            frsActivity52.bfz = oVar13.RA();
                            eVar = this.bgz.bfA;
                            if (eVar != null) {
                            }
                            aVar5 = this.bgz.bfS;
                            oVar14 = this.bgz.bfF;
                            aVar5.cz(oVar14.aKR());
                        }
                        if (this.bgz.aWx > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bgz.aWx, this.bgz.Po().Mo() - this.bgz.aWx, this.bgz.Po().Mm(), this.bgz.Po().Mn(), currentTimeMillis3 - this.bgz.Po().Ml());
                            this.bgz.aWx = -1L;
                        }
                        this.bgz.aAK = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                        oVar48 = this.bgz.bfF;
                        oVar48.aQ(this.bgz.getPageContext().getPageActivity());
                        oVar49 = this.bgz.bfF;
                        if (oVar49.aoE() != null) {
                            oVar51 = this.bgz.bfF;
                            str = oVar51.aoE().getId();
                        } else {
                            str = "";
                        }
                        oVar50 = this.bgz.bfF;
                        oVar50.W(this.bgz.getPageContext().getPageActivity(), str);
                    }
                    aVar7 = this.bgz.bfV;
                    oVar44 = this.bgz.bfF;
                    ArrayList<com.baidu.adp.widget.ListView.u> threadList = oVar44.getThreadList();
                    eVar3 = this.bgz.bfA;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, threadList, eVar3);
                    if (a2 != null) {
                        oVar45 = this.bgz.bfF;
                        oVar45.an(a2);
                        oVar46 = this.bgz.bfF;
                        oVar46.aLr();
                        cn cnVar4 = this.bgz.bfD;
                        int i7 = this.bgz.mPn;
                        oVar47 = this.bgz.bfF;
                        i4 = this.bgz.bfW;
                        cnVar4.a(a2, i7, oVar47, i4);
                        return;
                    }
                    return;
                }
            }
            this.bgz.bfD.Qp();
            if (i != 4) {
            }
        }
        this.bgz.bfD.Qn();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.bgz.Po().Rs()) && !"frs_page".equals(this.bgz.Po().Rs())) {
                return;
            }
            this.bgz.a(mVar);
        }
    }
}
