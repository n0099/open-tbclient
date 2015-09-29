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
class aq implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity aUz;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void ft(int i) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        this.startTime = System.nanoTime();
        bsVar = this.aUz.aTJ;
        if (bsVar != null) {
            switch (i) {
                case 1:
                    bsVar5 = this.aUz.aTJ;
                    bsVar5.cd(true);
                    bsVar6 = this.aUz.aTJ;
                    bsVar6.LQ();
                    return;
                case 2:
                    bsVar2 = this.aUz.aTJ;
                    bsVar2.ce(true);
                    bsVar3 = this.aUz.aTJ;
                    bsVar3.LQ();
                    return;
                case 3:
                    bsVar4 = this.aUz.aTJ;
                    bsVar4.cc(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b2, code lost:
        if (r1.avt().size() == 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014b  */
    @Override // com.baidu.tieba.tbadkCore.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e.a aVar) {
        bs bsVar;
        com.baidu.tieba.tbadkCore.o oVar;
        int i2;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        boolean z2;
        bs bsVar9;
        bs bsVar10;
        bs bsVar11;
        bs bsVar12;
        bs bsVar13;
        bs bsVar14;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        bs bsVar15;
        com.baidu.tieba.tbadkCore.o oVar6;
        boolean z3;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.frs.b.a aVar2;
        com.baidu.tieba.tbadkCore.o oVar8;
        com.baidu.tieba.tbadkCore.o oVar9;
        com.baidu.tieba.tbadkCore.o oVar10;
        com.baidu.tieba.frs.b.k kVar;
        com.baidu.tieba.tbadkCore.o oVar11;
        com.baidu.tieba.frs.loadmore.a aVar3;
        com.baidu.tieba.tbadkCore.o oVar12;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.frs.b.a aVar4;
        com.baidu.tieba.tbadkCore.o oVar13;
        com.baidu.tieba.tbadkCore.o oVar14;
        com.baidu.tieba.tbadkCore.o oVar15;
        com.baidu.tieba.frs.b.k kVar2;
        com.baidu.tieba.tbadkCore.o oVar16;
        com.baidu.tieba.tbadkCore.o oVar17;
        com.baidu.tieba.tbadkCore.o oVar18;
        com.baidu.tieba.frs.b.k kVar3;
        com.baidu.tieba.tbadkCore.o oVar19;
        com.baidu.tieba.tbadkCore.o oVar20;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.o oVar21;
        com.baidu.tieba.tbadkCore.o oVar22;
        com.baidu.tieba.frs.mc.a aVar5;
        com.baidu.tieba.tbadkCore.o oVar23;
        com.baidu.tieba.tbadkCore.o oVar24;
        com.baidu.tieba.tbadkCore.o oVar25;
        com.baidu.tieba.tbadkCore.o oVar26;
        com.baidu.tieba.tbadkCore.o oVar27;
        com.baidu.tieba.tbadkCore.o oVar28;
        com.baidu.tieba.tbadkCore.o oVar29;
        com.baidu.tieba.tbadkCore.o oVar30;
        bs bsVar16;
        com.baidu.tieba.tbadkCore.o oVar31;
        com.baidu.tieba.tbadkCore.o oVar32;
        com.baidu.tieba.frs.b.a aVar6;
        com.baidu.tieba.tbadkCore.o oVar33;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.o oVar34;
        com.baidu.tieba.tbadkCore.o oVar35;
        bs bsVar17;
        int i5;
        com.baidu.tieba.tbadkCore.o oVar36;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar37;
        com.baidu.tieba.tbadkCore.o oVar38;
        bs bsVar18;
        com.baidu.tieba.tbadkCore.o oVar39;
        bs bsVar19;
        com.baidu.tieba.tbadkCore.o oVar40;
        com.baidu.tieba.frs.loadmore.a aVar8;
        bs bsVar20;
        this.aUz.aUi = true;
        if (aVar != null && aVar.isSuccess) {
            bsVar20 = this.aUz.aTJ;
            bsVar20.LZ().bV(com.baidu.tbadk.core.util.as.uI().uK());
            FrsActivity.aTQ = 0L;
            FrsActivity.aTR = 0L;
            FrsActivity.aTS = 0;
        } else {
            FrsActivity.aTS = 1;
        }
        if (i == 3) {
            aVar8 = this.aUz.aUb;
            aVar8.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bsVar = this.aUz.aTJ;
        bsVar.cc(false);
        if (this.aUz.Lm().MR() != null) {
            this.aUz.aTL = this.aUz.Lm().MR();
        }
        FrsActivity frsActivity = this.aUz;
        oVar = this.aUz.aTL;
        frsActivity.aUc = oVar.getPage().rL();
        i2 = this.aUz.aUc;
        if (i2 == 0) {
            oVar37 = this.aUz.aTL;
            if (oVar37.avt() != null) {
                oVar40 = this.aUz.aTL;
            }
            oVar38 = this.aUz.aTL;
            if (oVar38.getThreadList() != null) {
                oVar39 = this.aUz.aTL;
                if (oVar39.getThreadList().size() != 0) {
                    bsVar19 = this.aUz.aTJ;
                    bsVar19.Mf();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                bsVar5 = this.aUz.aTJ;
                                bsVar5.cd(false);
                                bsVar6 = this.aUz.aTJ;
                                bsVar6.LQ();
                                break;
                            case 2:
                                bsVar3 = this.aUz.aTJ;
                                bsVar3.ce(false);
                                bsVar4 = this.aUz.aTJ;
                                bsVar4.LQ();
                                break;
                        }
                        FrsActivity frsActivity2 = this.aUz;
                        bsVar7 = this.aUz.aTJ;
                        frsActivity2.hideLoadingView(bsVar7.getRootView());
                        bsVar8 = this.aUz.aTJ;
                        bsVar8.LX();
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.aUz.aTw;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.cWu) {
                                        if (340001 == aVar.errorCode) {
                                            FrsActivity frsActivity3 = this.aUz;
                                            bsVar14 = this.aUz.aTJ;
                                            frsActivity3.showNetRefreshViewNoClick(bsVar14.getRootView(), this.aUz.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            FrsActivity frsActivity4 = this.aUz;
                                            bsVar13 = this.aUz.aTJ;
                                            frsActivity4.showNetRefreshView(bsVar13.getRootView(), this.aUz.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        FrsActivity frsActivity5 = this.aUz;
                                        bsVar11 = this.aUz.aTJ;
                                        frsActivity5.showNetRefreshViewNoClick(bsVar11.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        FrsActivity frsActivity6 = this.aUz;
                                        bsVar10 = this.aUz.aTJ;
                                        frsActivity6.showNetRefreshView(bsVar10.getRootView(), aVar.errorMsg, true);
                                    }
                                    bsVar12 = this.aUz.aTJ;
                                    bsVar12.fA(8);
                                }
                            } else if (aVar != null && aVar.cWu) {
                                bsVar9 = this.aUz.aTJ;
                                bsVar9.fA(0);
                                this.aUz.showToast(this.aUz.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.aUz.aTw = true;
                            this.aUz.aTI = true;
                            bsVar15 = this.aUz.aTJ;
                            bsVar15.fA(0);
                            oVar6 = this.aUz.aTL;
                            if (oVar6 != null) {
                                FrsActivity frsActivity7 = this.aUz;
                                oVar28 = this.aUz.aTL;
                                frsActivity7.aTB = oVar28.aeN().getName();
                                FrsActivity frsActivity8 = this.aUz;
                                oVar29 = this.aUz.aTL;
                                frsActivity8.forumId = oVar29.aeN().getId();
                                oVar30 = this.aUz.aTL;
                                if (oVar30.aeN().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.aUz.aTZ;
                                    oVar33 = this.aUz.aTL;
                                    aVar6.fT(oVar33.getUserData().getIsMem());
                                }
                                bsVar16 = this.aUz.aTJ;
                                oVar31 = this.aUz.aTL;
                                ForumData aeN = oVar31.aeN();
                                oVar32 = this.aUz.aTL;
                                bsVar16.b(aeN, oVar32.getUserData());
                            }
                            z3 = this.aUz.aTW;
                            if (z3) {
                                oVar22 = this.aUz.aTL;
                                if (oVar22 != null) {
                                    aVar5 = this.aUz.aTX;
                                    if (aVar5.Ng() == 1) {
                                        oVar23 = this.aUz.aTL;
                                        oVar23.avL();
                                        if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                            oVar27 = this.aUz.aTL;
                                            oVar27.aP(this.aUz.getPageContext().getPageActivity());
                                        }
                                        oVar24 = this.aUz.aTL;
                                        oVar24.avP();
                                        if (!this.aUz.Lm().Nd() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                            oVar25 = this.aUz.aTL;
                                            oVar25.avO();
                                            oVar26 = this.aUz.aTL;
                                            oVar26.avN();
                                        }
                                    }
                                }
                            }
                            oVar7 = this.aUz.aTL;
                            com.baidu.tbadk.core.data.x top_notice_data = oVar7.aeN().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.v vVar = new com.baidu.tbadk.core.data.v();
                                vVar.setTitle(top_notice_data.getTitle());
                                vVar.bA(2);
                                vVar.cm(top_notice_data.sK());
                                vVar.parser_title();
                                oVar21 = this.aUz.aTL;
                                oVar21.f(vVar);
                            }
                            aVar2 = this.aUz.aTZ;
                            String Nc = this.aUz.Lm().Nc();
                            oVar8 = this.aUz.aTL;
                            aVar2.a(Nc, oVar8);
                            FrsActivity.aTQ = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.aTR = aVar.cWv;
                            }
                            oVar9 = this.aUz.aTL;
                            if (oVar9 != null) {
                                oVar19 = this.aUz.aTL;
                                if (oVar19.getThreadList() != null) {
                                    oVar20 = this.aUz.aTL;
                                    if (oVar20.getThreadList().size() == 0 && this.aUz.Lm().getType() == 4) {
                                        this.aUz.showToast(this.aUz.getPageContext().getString(i.h.no_more_to_load));
                                        i3 = this.aUz.mPn;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.aUz;
                                            i4 = frsActivity9.mPn;
                                            frsActivity9.mPn = i4 - 1;
                                        }
                                        if (this.aUz.aLy > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aUz.aLy, this.aUz.Lm().IA() - this.aUz.aLy, this.aUz.Lm().Iy(), this.aUz.Lm().Iz(), currentTimeMillis2 - this.aUz.Lm().Ix());
                                            this.aUz.aLy = -1L;
                                        }
                                        this.aUz.axx = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            oVar10 = this.aUz.aTL;
                            if (oVar10 != null) {
                                oVar17 = this.aUz.aTL;
                                if (oVar17.getUserData() != null) {
                                    oVar18 = this.aUz.aTL;
                                    if (oVar18.getUserData().isBawu()) {
                                        kVar3 = this.aUz.aUa;
                                        kVar3.setIsManager(true);
                                        oVar11 = this.aUz.aTL;
                                        if (oVar11 != null) {
                                            oVar15 = this.aUz.aTL;
                                            if (oVar15.aeN() != null) {
                                                kVar2 = this.aUz.aUa;
                                                oVar16 = this.aUz.aTL;
                                                kVar2.cl(oVar16.aeN().isLike() == 1);
                                            }
                                        }
                                        aVar3 = this.aUz.aUb;
                                        oVar12 = this.aUz.aTL;
                                        a = aVar3.a(true, oVar12.getThreadList());
                                        if (a != null) {
                                            oVar14 = this.aUz.aTL;
                                            oVar14.af(a);
                                        }
                                        this.aUz.La();
                                        aVar4 = this.aUz.aTZ;
                                        oVar13 = this.aUz.aTL;
                                        aVar4.cj(oVar13.avq());
                                    }
                                }
                            }
                            kVar = this.aUz.aUa;
                            kVar.setIsManager(false);
                            oVar11 = this.aUz.aTL;
                            if (oVar11 != null) {
                            }
                            aVar3 = this.aUz.aUb;
                            oVar12 = this.aUz.aTL;
                            a = aVar3.a(true, oVar12.getThreadList());
                            if (a != null) {
                            }
                            this.aUz.La();
                            aVar4 = this.aUz.aTZ;
                            oVar13 = this.aUz.aTL;
                            aVar4.cj(oVar13.avq());
                        }
                        FrsActivity frsActivity10 = this.aUz;
                        oVar2 = this.aUz.aTL;
                        frsActivity10.aTF = oVar2.Nj();
                        if (this.aUz.aLy > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aUz.aLy, this.aUz.Lm().IA() - this.aUz.aLy, this.aUz.Lm().Iy(), this.aUz.Lm().Iz(), currentTimeMillis3 - this.aUz.Lm().Ix());
                            this.aUz.aLy = -1L;
                        }
                        oVar3 = this.aUz.aTL;
                        if (oVar3 != null) {
                            oVar4 = this.aUz.aTL;
                            if (oVar4.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                oVar5 = this.aUz.aTL;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(oVar5.getUserData().getIsMem())));
                            }
                        }
                        this.aUz.axx = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar7 = this.aUz.aUb;
                    oVar34 = this.aUz.aTL;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, oVar34.getThreadList());
                    if (a2 != null) {
                        oVar35 = this.aUz.aTL;
                        oVar35.af(a2);
                        bsVar17 = this.aUz.aTJ;
                        i5 = this.aUz.mPn;
                        oVar36 = this.aUz.aTL;
                        i6 = this.aUz.aUc;
                        bsVar17.a(a2, i5, oVar36, i6);
                        return;
                    }
                    return;
                }
            }
            bsVar18 = this.aUz.aTJ;
            bsVar18.Mg();
            if (i != 4) {
            }
        }
        bsVar2 = this.aUz.aTJ;
        bsVar2.Me();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.aUz.Lm().Nc()) && !"frs_page".equals(this.aUz.Lm().Nc())) {
                return;
            }
            this.aUz.a(mVar);
        }
    }
}
