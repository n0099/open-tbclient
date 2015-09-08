package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity aVz;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void fo(int i) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                biVar3 = this.aVz.aUL;
                biVar3.cg(true);
                biVar4 = this.aVz.aUL;
                biVar4.LR();
                return;
            case 2:
                biVar = this.aVz.aUL;
                biVar.ch(true);
                biVar2 = this.aVz.aUL;
                biVar2.LR();
                return;
            case 3:
                biVar5 = this.aVz.aUL;
                biVar5.cf(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00aa, code lost:
        if (r1.atd().size() == 0) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143  */
    @Override // com.baidu.tieba.tbadkCore.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e.a aVar) {
        bi biVar;
        com.baidu.tieba.tbadkCore.o oVar;
        int i2;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        boolean z2;
        bi biVar9;
        bi biVar10;
        bi biVar11;
        bi biVar12;
        bi biVar13;
        bi biVar14;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        bi biVar15;
        com.baidu.tieba.tbadkCore.o oVar5;
        boolean z3;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.tbadkCore.o oVar8;
        com.baidu.tieba.tbadkCore.o oVar9;
        com.baidu.tieba.frs.c.k kVar;
        com.baidu.tieba.tbadkCore.o oVar10;
        com.baidu.tieba.frs.loadmore.a aVar3;
        com.baidu.tieba.tbadkCore.o oVar11;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.frs.c.a aVar4;
        com.baidu.tieba.tbadkCore.o oVar12;
        com.baidu.tieba.tbadkCore.o oVar13;
        com.baidu.tieba.tbadkCore.o oVar14;
        com.baidu.tieba.frs.c.k kVar2;
        com.baidu.tieba.tbadkCore.o oVar15;
        com.baidu.tieba.tbadkCore.o oVar16;
        com.baidu.tieba.tbadkCore.o oVar17;
        com.baidu.tieba.frs.c.k kVar3;
        com.baidu.tieba.tbadkCore.o oVar18;
        com.baidu.tieba.tbadkCore.o oVar19;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.o oVar20;
        com.baidu.tieba.tbadkCore.o oVar21;
        com.baidu.tieba.frs.b.a aVar5;
        com.baidu.tieba.tbadkCore.o oVar22;
        com.baidu.tieba.tbadkCore.o oVar23;
        com.baidu.tieba.tbadkCore.o oVar24;
        com.baidu.tieba.tbadkCore.o oVar25;
        com.baidu.tieba.tbadkCore.o oVar26;
        com.baidu.tieba.tbadkCore.o oVar27;
        com.baidu.tieba.tbadkCore.o oVar28;
        com.baidu.tieba.tbadkCore.o oVar29;
        bi biVar16;
        com.baidu.tieba.tbadkCore.o oVar30;
        com.baidu.tieba.tbadkCore.o oVar31;
        com.baidu.tieba.frs.c.a aVar6;
        com.baidu.tieba.tbadkCore.o oVar32;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.o oVar33;
        com.baidu.tieba.tbadkCore.o oVar34;
        bi biVar17;
        int i5;
        com.baidu.tieba.tbadkCore.o oVar35;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar36;
        com.baidu.tieba.tbadkCore.o oVar37;
        bi biVar18;
        com.baidu.tieba.tbadkCore.o oVar38;
        bi biVar19;
        com.baidu.tieba.tbadkCore.o oVar39;
        com.baidu.tieba.frs.loadmore.a aVar8;
        bi biVar20;
        if (aVar != null && aVar.isSuccess) {
            biVar20 = this.aVz.aUL;
            biVar20.Ma().bY(com.baidu.tbadk.core.util.ar.uK().uM());
            FrsActivity.aUS = 0L;
            FrsActivity.aUT = 0L;
            FrsActivity.aUU = 0;
        } else {
            FrsActivity.aUU = 1;
        }
        if (i == 3) {
            aVar8 = this.aVz.aVd;
            aVar8.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        biVar = this.aVz.aUL;
        biVar.cf(false);
        if (this.aVz.Lq().MS() != null) {
            this.aVz.aUN = this.aVz.Lq().MS();
        }
        FrsActivity frsActivity = this.aVz;
        oVar = this.aVz.aUN;
        frsActivity.aVe = oVar.getPage().rQ();
        i2 = this.aVz.aVe;
        if (i2 == 0) {
            oVar36 = this.aVz.aUN;
            if (oVar36.atd() != null) {
                oVar39 = this.aVz.aUN;
            }
            oVar37 = this.aVz.aUN;
            if (oVar37.getThreadList() != null) {
                oVar38 = this.aVz.aUN;
                if (oVar38.getThreadList().size() != 0) {
                    biVar19 = this.aVz.aUL;
                    biVar19.Mg();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                biVar5 = this.aVz.aUL;
                                biVar5.cg(false);
                                biVar6 = this.aVz.aUL;
                                biVar6.LR();
                                break;
                            case 2:
                                biVar3 = this.aVz.aUL;
                                biVar3.ch(false);
                                biVar4 = this.aVz.aUL;
                                biVar4.LR();
                                break;
                        }
                        FrsActivity frsActivity2 = this.aVz;
                        biVar7 = this.aVz.aUL;
                        frsActivity2.hideLoadingView(biVar7.getRootView());
                        biVar8 = this.aVz.aUL;
                        biVar8.LY();
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.aVz.aUA;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.cPd) {
                                        if (340001 == aVar.errorCode) {
                                            FrsActivity frsActivity3 = this.aVz;
                                            biVar14 = this.aVz.aUL;
                                            frsActivity3.showNetRefreshViewNoClick(biVar14.getRootView(), this.aVz.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            FrsActivity frsActivity4 = this.aVz;
                                            biVar13 = this.aVz.aUL;
                                            frsActivity4.showNetRefreshView(biVar13.getRootView(), this.aVz.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        FrsActivity frsActivity5 = this.aVz;
                                        biVar11 = this.aVz.aUL;
                                        frsActivity5.showNetRefreshViewNoClick(biVar11.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        FrsActivity frsActivity6 = this.aVz;
                                        biVar10 = this.aVz.aUL;
                                        frsActivity6.showNetRefreshView(biVar10.getRootView(), aVar.errorMsg, true);
                                    }
                                    biVar12 = this.aVz.aUL;
                                    biVar12.fv(8);
                                }
                            } else if (aVar != null && aVar.cPd) {
                                biVar9 = this.aVz.aUL;
                                biVar9.fv(0);
                                this.aVz.showToast(this.aVz.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.aVz.aUA = true;
                            this.aVz.aUK = true;
                            biVar15 = this.aVz.aUL;
                            biVar15.fv(0);
                            oVar5 = this.aVz.aUN;
                            if (oVar5 != null) {
                                FrsActivity frsActivity7 = this.aVz;
                                oVar27 = this.aVz.aUN;
                                frsActivity7.aUF = oVar27.acP().getName();
                                FrsActivity frsActivity8 = this.aVz;
                                oVar28 = this.aVz.aUN;
                                frsActivity8.forumId = oVar28.acP().getId();
                                oVar29 = this.aVz.aUN;
                                if (oVar29.acP().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.aVz.aVb;
                                    oVar32 = this.aVz.aUN;
                                    aVar6.fO(oVar32.getUserData().getIsMem());
                                }
                                biVar16 = this.aVz.aUL;
                                oVar30 = this.aVz.aUN;
                                ForumData acP = oVar30.acP();
                                oVar31 = this.aVz.aUN;
                                biVar16.b(acP, oVar31.getUserData());
                            }
                            z3 = this.aVz.aUY;
                            if (z3) {
                                oVar21 = this.aVz.aUN;
                                if (oVar21 != null) {
                                    aVar5 = this.aVz.aUZ;
                                    if (aVar5.Nh() == 1) {
                                        oVar22 = this.aVz.aUN;
                                        oVar22.atv();
                                        if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                            oVar26 = this.aVz.aUN;
                                            oVar26.aQ(this.aVz.getPageContext().getPageActivity());
                                        }
                                        oVar23 = this.aVz.aUN;
                                        oVar23.atz();
                                        if (!this.aVz.Lq().Ne() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                            oVar24 = this.aVz.aUN;
                                            oVar24.aty();
                                            oVar25 = this.aVz.aUN;
                                            oVar25.atx();
                                        }
                                    }
                                }
                            }
                            oVar6 = this.aVz.aUN;
                            com.baidu.tbadk.core.data.z top_notice_data = oVar6.acP().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                                xVar.setTitle(top_notice_data.getTitle());
                                xVar.bA(2);
                                xVar.cm(top_notice_data.sN());
                                xVar.parser_title();
                                oVar20 = this.aVz.aUN;
                                oVar20.f(xVar);
                            }
                            aVar2 = this.aVz.aVb;
                            String Nd = this.aVz.Lq().Nd();
                            oVar7 = this.aVz.aUN;
                            aVar2.a(Nd, oVar7);
                            FrsActivity.aUS = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.aUT = aVar.cPe;
                            }
                            oVar8 = this.aVz.aUN;
                            if (oVar8 != null) {
                                oVar18 = this.aVz.aUN;
                                if (oVar18.getThreadList() != null) {
                                    oVar19 = this.aVz.aUN;
                                    if (oVar19.getThreadList().size() == 0 && this.aVz.Lq().getType() == 4) {
                                        this.aVz.showToast(this.aVz.getPageContext().getString(i.h.no_more_to_load));
                                        i3 = this.aVz.mPn;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.aVz;
                                            i4 = frsActivity9.mPn;
                                            frsActivity9.mPn = i4 - 1;
                                        }
                                        if (this.aVz.aMD > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aVz.aMD, this.aVz.Lq().IE() - this.aVz.aMD, this.aVz.Lq().IC(), this.aVz.Lq().ID(), currentTimeMillis2 - this.aVz.Lq().IB());
                                            this.aVz.aMD = -1L;
                                        }
                                        this.aVz.ayY = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            oVar9 = this.aVz.aUN;
                            if (oVar9 != null) {
                                oVar16 = this.aVz.aUN;
                                if (oVar16.getUserData() != null) {
                                    oVar17 = this.aVz.aUN;
                                    if (oVar17.getUserData().isBawu()) {
                                        kVar3 = this.aVz.aVc;
                                        kVar3.setIsManager(true);
                                        oVar10 = this.aVz.aUN;
                                        if (oVar10 != null) {
                                            oVar14 = this.aVz.aUN;
                                            if (oVar14.acP() != null) {
                                                kVar2 = this.aVz.aVc;
                                                oVar15 = this.aVz.aUN;
                                                kVar2.co(oVar15.acP().isLike() == 1);
                                            }
                                        }
                                        aVar3 = this.aVz.aVd;
                                        oVar11 = this.aVz.aUN;
                                        a = aVar3.a(true, oVar11.getThreadList());
                                        if (a != null) {
                                            oVar13 = this.aVz.aUN;
                                            oVar13.ad(a);
                                        }
                                        this.aVz.Le();
                                        aVar4 = this.aVz.aVb;
                                        oVar12 = this.aVz.aUN;
                                        aVar4.cm(oVar12.ata());
                                    }
                                }
                            }
                            kVar = this.aVz.aVc;
                            kVar.setIsManager(false);
                            oVar10 = this.aVz.aUN;
                            if (oVar10 != null) {
                            }
                            aVar3 = this.aVz.aVd;
                            oVar11 = this.aVz.aUN;
                            a = aVar3.a(true, oVar11.getThreadList());
                            if (a != null) {
                            }
                            this.aVz.Le();
                            aVar4 = this.aVz.aVb;
                            oVar12 = this.aVz.aUN;
                            aVar4.cm(oVar12.ata());
                        }
                        if (this.aVz.aMD > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aVz.aMD, this.aVz.Lq().IE() - this.aVz.aMD, this.aVz.Lq().IC(), this.aVz.Lq().ID(), currentTimeMillis3 - this.aVz.Lq().IB());
                            this.aVz.aMD = -1L;
                        }
                        oVar2 = this.aVz.aUN;
                        if (oVar2 != null) {
                            oVar3 = this.aVz.aUN;
                            if (oVar3.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                oVar4 = this.aVz.aUN;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(oVar4.getUserData().getIsMem())));
                            }
                        }
                        this.aVz.ayY = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar7 = this.aVz.aVd;
                    oVar33 = this.aVz.aUN;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, oVar33.getThreadList());
                    if (a2 != null) {
                        oVar34 = this.aVz.aUN;
                        oVar34.ad(a2);
                        biVar17 = this.aVz.aUL;
                        i5 = this.aVz.mPn;
                        oVar35 = this.aVz.aUN;
                        i6 = this.aVz.aVe;
                        biVar17.a(a2, i5, oVar35, i6);
                        return;
                    }
                    return;
                }
            }
            biVar18 = this.aVz.aUL;
            biVar18.Mh();
            if (i != 4) {
            }
        }
        biVar2 = this.aVz.aUL;
        biVar2.Mf();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.aVz.Lq().Nd()) && !"frs_page".equals(this.aVz.Lq().Nd())) {
                return;
            }
            this.aVz.a(mVar);
        }
    }
}
