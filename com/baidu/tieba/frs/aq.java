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
    final /* synthetic */ FrsActivity aUS;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void fB(int i) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        this.startTime = System.nanoTime();
        bsVar = this.aUS.aUc;
        if (bsVar != null) {
            switch (i) {
                case 1:
                    bsVar5 = this.aUS.aUc;
                    bsVar5.cf(true);
                    bsVar6 = this.aUS.aUc;
                    bsVar6.Mc();
                    return;
                case 2:
                    bsVar2 = this.aUS.aUc;
                    bsVar2.cg(true);
                    bsVar3 = this.aUS.aUc;
                    bsVar3.Mc();
                    return;
                case 3:
                    bsVar4 = this.aUS.aUc;
                    bsVar4.ce(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b2, code lost:
        if (r1.awc().size() == 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x06ae  */
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
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        bs bsVar7;
        bs bsVar8;
        boolean z2;
        bs bsVar9;
        bs bsVar10;
        bs bsVar11;
        bs bsVar12;
        bs bsVar13;
        bs bsVar14;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.tbadkCore.o oVar7;
        bs bsVar15;
        com.baidu.tieba.tbadkCore.o oVar8;
        boolean z3;
        com.baidu.tieba.tbadkCore.o oVar9;
        com.baidu.tieba.frs.b.a aVar2;
        com.baidu.tieba.tbadkCore.o oVar10;
        com.baidu.tieba.tbadkCore.o oVar11;
        com.baidu.tieba.tbadkCore.o oVar12;
        com.baidu.tieba.frs.b.l lVar;
        com.baidu.tieba.tbadkCore.o oVar13;
        com.baidu.tieba.frs.loadmore.a aVar3;
        com.baidu.tieba.tbadkCore.o oVar14;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.frs.b.a aVar4;
        com.baidu.tieba.tbadkCore.o oVar15;
        com.baidu.tieba.tbadkCore.o oVar16;
        com.baidu.tieba.tbadkCore.o oVar17;
        com.baidu.tieba.frs.b.l lVar2;
        com.baidu.tieba.tbadkCore.o oVar18;
        com.baidu.tieba.tbadkCore.o oVar19;
        com.baidu.tieba.tbadkCore.o oVar20;
        com.baidu.tieba.frs.b.l lVar3;
        com.baidu.tieba.tbadkCore.o oVar21;
        com.baidu.tieba.tbadkCore.o oVar22;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.o oVar23;
        com.baidu.tieba.tbadkCore.o oVar24;
        com.baidu.tieba.frs.mc.a aVar5;
        com.baidu.tieba.tbadkCore.o oVar25;
        com.baidu.tieba.tbadkCore.o oVar26;
        com.baidu.tieba.tbadkCore.o oVar27;
        com.baidu.tieba.tbadkCore.o oVar28;
        com.baidu.tieba.tbadkCore.o oVar29;
        com.baidu.tieba.tbadkCore.o oVar30;
        com.baidu.tieba.tbadkCore.o oVar31;
        com.baidu.tieba.tbadkCore.o oVar32;
        bs bsVar16;
        com.baidu.tieba.tbadkCore.o oVar33;
        com.baidu.tieba.tbadkCore.o oVar34;
        com.baidu.tieba.frs.b.a aVar6;
        com.baidu.tieba.tbadkCore.o oVar35;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.o oVar36;
        com.baidu.tieba.tbadkCore.o oVar37;
        bs bsVar17;
        int i5;
        com.baidu.tieba.tbadkCore.o oVar38;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar39;
        com.baidu.tieba.tbadkCore.o oVar40;
        bs bsVar18;
        com.baidu.tieba.tbadkCore.o oVar41;
        bs bsVar19;
        com.baidu.tieba.tbadkCore.o oVar42;
        com.baidu.tieba.frs.loadmore.a aVar8;
        bs bsVar20;
        this.aUS.aUB = true;
        if (aVar != null && aVar.isSuccess) {
            bsVar20 = this.aUS.aUc;
            bsVar20.Ml().bX(com.baidu.tbadk.core.util.at.uK().uM());
            FrsActivity.aUj = 0L;
            FrsActivity.aUk = 0L;
            FrsActivity.aUl = 0;
        } else {
            FrsActivity.aUl = 1;
        }
        if (i == 3) {
            aVar8 = this.aUS.aUu;
            aVar8.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bsVar = this.aUS.aUc;
        bsVar.ce(false);
        if (this.aUS.Ly().Nf() != null) {
            this.aUS.aUe = this.aUS.Ly().Nf();
        }
        FrsActivity frsActivity = this.aUS;
        oVar = this.aUS.aUe;
        frsActivity.aUv = oVar.getPage().rK();
        i2 = this.aUS.aUv;
        if (i2 == 0) {
            oVar39 = this.aUS.aUe;
            if (oVar39.awc() != null) {
                oVar42 = this.aUS.aUe;
            }
            oVar40 = this.aUS.aUe;
            if (oVar40.getThreadList() != null) {
                oVar41 = this.aUS.aUe;
                if (oVar41.getThreadList().size() != 0) {
                    bsVar19 = this.aUS.aUc;
                    bsVar19.Mr();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                bsVar5 = this.aUS.aUc;
                                bsVar5.cf(false);
                                bsVar6 = this.aUS.aUc;
                                bsVar6.Mc();
                                break;
                            case 2:
                                bsVar3 = this.aUS.aUc;
                                bsVar3.cg(false);
                                bsVar4 = this.aUS.aUc;
                                bsVar4.Mc();
                                break;
                            case 3:
                                eVar = this.aUS.aTZ;
                                if (eVar != null) {
                                    eVar2 = this.aUS.aTZ;
                                    eVar2.awV();
                                }
                                oVar2 = this.aUS.aUe;
                                if (oVar2 != null) {
                                    oVar3 = this.aUS.aUe;
                                    oVar3.awu();
                                    break;
                                }
                                break;
                        }
                        FrsActivity frsActivity2 = this.aUS;
                        bsVar7 = this.aUS.aUc;
                        frsActivity2.hideLoadingView(bsVar7.getRootView());
                        bsVar8 = this.aUS.aUc;
                        bsVar8.Mj();
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.aUS.aTP;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.cYp) {
                                        if (340001 == aVar.errorCode) {
                                            FrsActivity frsActivity3 = this.aUS;
                                            bsVar14 = this.aUS.aUc;
                                            frsActivity3.showNetRefreshViewNoClick(bsVar14.getRootView(), this.aUS.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            FrsActivity frsActivity4 = this.aUS;
                                            bsVar13 = this.aUS.aUc;
                                            frsActivity4.showNetRefreshView(bsVar13.getRootView(), this.aUS.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        FrsActivity frsActivity5 = this.aUS;
                                        bsVar11 = this.aUS.aUc;
                                        frsActivity5.showNetRefreshViewNoClick(bsVar11.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        FrsActivity frsActivity6 = this.aUS;
                                        bsVar10 = this.aUS.aUc;
                                        frsActivity6.showNetRefreshView(bsVar10.getRootView(), aVar.errorMsg, true);
                                    }
                                    bsVar12 = this.aUS.aUc;
                                    bsVar12.fI(8);
                                }
                            } else if (aVar != null && aVar.cYp) {
                                bsVar9 = this.aUS.aUc;
                                bsVar9.fI(0);
                                this.aUS.showToast(this.aUS.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.aUS.aTP = true;
                            this.aUS.aUb = true;
                            bsVar15 = this.aUS.aUc;
                            bsVar15.fI(0);
                            oVar8 = this.aUS.aUe;
                            if (oVar8 != null) {
                                FrsActivity frsActivity7 = this.aUS;
                                oVar30 = this.aUS.aUe;
                                frsActivity7.aTU = oVar30.afg().getName();
                                FrsActivity frsActivity8 = this.aUS;
                                oVar31 = this.aUS.aUe;
                                frsActivity8.forumId = oVar31.afg().getId();
                                oVar32 = this.aUS.aUe;
                                if (oVar32.afg().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.aUS.aUs;
                                    oVar35 = this.aUS.aUe;
                                    aVar6.gf(oVar35.getUserData().getIsMem());
                                }
                                bsVar16 = this.aUS.aUc;
                                oVar33 = this.aUS.aUe;
                                ForumData afg = oVar33.afg();
                                oVar34 = this.aUS.aUe;
                                bsVar16.a(afg, oVar34.getUserData(), 1);
                            }
                            z3 = this.aUS.aUp;
                            if (z3) {
                                oVar24 = this.aUS.aUe;
                                if (oVar24 != null) {
                                    aVar5 = this.aUS.aUq;
                                    if (aVar5.Nv() == 1) {
                                        oVar25 = this.aUS.aUe;
                                        oVar25.awx();
                                        oVar26 = this.aUS.aUe;
                                        oVar26.awB();
                                        if (!this.aUS.Ly().Nr() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                            oVar28 = this.aUS.aUe;
                                            oVar28.awA();
                                            oVar29 = this.aUS.aUe;
                                            oVar29.awz();
                                        }
                                        if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                            oVar27 = this.aUS.aUe;
                                            oVar27.aO(this.aUS.getPageContext().getPageActivity());
                                        }
                                    }
                                }
                            }
                            oVar9 = this.aUS.aUe;
                            com.baidu.tbadk.core.data.y top_notice_data = oVar9.afg().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                                wVar.setTitle(top_notice_data.getTitle());
                                wVar.bA(2);
                                wVar.cm(top_notice_data.sK());
                                wVar.parser_title();
                                oVar23 = this.aUS.aUe;
                                oVar23.f(wVar);
                            }
                            aVar2 = this.aUS.aUs;
                            String Nq = this.aUS.Ly().Nq();
                            oVar10 = this.aUS.aUe;
                            aVar2.a(Nq, oVar10);
                            FrsActivity.aUj = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.aUk = aVar.cYq;
                            }
                            oVar11 = this.aUS.aUe;
                            if (oVar11 != null) {
                                oVar21 = this.aUS.aUe;
                                if (oVar21.getThreadList() != null) {
                                    oVar22 = this.aUS.aUe;
                                    if (oVar22.getThreadList().size() == 0 && this.aUS.Ly().getType() == 4) {
                                        this.aUS.showToast(this.aUS.getPageContext().getString(i.h.no_more_to_load));
                                        i3 = this.aUS.mPn;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.aUS;
                                            i4 = frsActivity9.mPn;
                                            frsActivity9.mPn = i4 - 1;
                                        }
                                        if (this.aUS.aLR > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aUS.aLR, this.aUS.Ly().IM() - this.aUS.aLR, this.aUS.Ly().IK(), this.aUS.Ly().IL(), currentTimeMillis2 - this.aUS.Ly().IJ());
                                            this.aUS.aLR = -1L;
                                        }
                                        this.aUS.awn = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            oVar12 = this.aUS.aUe;
                            if (oVar12 != null) {
                                oVar19 = this.aUS.aUe;
                                if (oVar19.getUserData() != null) {
                                    oVar20 = this.aUS.aUe;
                                    if (oVar20.getUserData().isBawu()) {
                                        lVar3 = this.aUS.aUt;
                                        lVar3.setIsManager(true);
                                        oVar13 = this.aUS.aUe;
                                        if (oVar13 != null) {
                                            oVar17 = this.aUS.aUe;
                                            if (oVar17.afg() != null) {
                                                lVar2 = this.aUS.aUt;
                                                oVar18 = this.aUS.aUe;
                                                lVar2.cn(oVar18.afg().isLike() == 1);
                                            }
                                        }
                                        aVar3 = this.aUS.aUu;
                                        oVar14 = this.aUS.aUe;
                                        a = aVar3.a(true, oVar14.getThreadList());
                                        if (a != null) {
                                            oVar16 = this.aUS.aUe;
                                            oVar16.af(a);
                                        }
                                        this.aUS.Lm();
                                        aVar4 = this.aUS.aUs;
                                        oVar15 = this.aUS.aUe;
                                        aVar4.cl(oVar15.avZ());
                                    }
                                }
                            }
                            lVar = this.aUS.aUt;
                            lVar.setIsManager(false);
                            oVar13 = this.aUS.aUe;
                            if (oVar13 != null) {
                            }
                            aVar3 = this.aUS.aUu;
                            oVar14 = this.aUS.aUe;
                            a = aVar3.a(true, oVar14.getThreadList());
                            if (a != null) {
                            }
                            this.aUS.Lm();
                            aVar4 = this.aUS.aUs;
                            oVar15 = this.aUS.aUe;
                            aVar4.cl(oVar15.avZ());
                        }
                        FrsActivity frsActivity10 = this.aUS;
                        oVar4 = this.aUS.aUe;
                        frsActivity10.aTY = oVar4.Ny();
                        if (this.aUS.aLR > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aUS.aLR, this.aUS.Ly().IM() - this.aUS.aLR, this.aUS.Ly().IK(), this.aUS.Ly().IL(), currentTimeMillis3 - this.aUS.Ly().IJ());
                            this.aUS.aLR = -1L;
                        }
                        oVar5 = this.aUS.aUe;
                        if (oVar5 != null) {
                            oVar6 = this.aUS.aUe;
                            if (oVar6.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                oVar7 = this.aUS.aUe;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(oVar7.getUserData().getIsMem())));
                            }
                        }
                        this.aUS.awn = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar7 = this.aUS.aUu;
                    oVar36 = this.aUS.aUe;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, oVar36.getThreadList());
                    if (a2 != null) {
                        oVar37 = this.aUS.aUe;
                        oVar37.af(a2);
                        bsVar17 = this.aUS.aUc;
                        i5 = this.aUS.mPn;
                        oVar38 = this.aUS.aUe;
                        i6 = this.aUS.aUv;
                        bsVar17.a(a2, i5, oVar38, i6);
                        return;
                    }
                    return;
                }
            }
            bsVar18 = this.aUS.aUc;
            bsVar18.Ms();
            if (i != 4) {
            }
        }
        bsVar2 = this.aUS.aUc;
        bsVar2.Mq();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.aUS.Ly().Nq()) && !"frs_page".equals(this.aUS.Ly().Nq())) {
                return;
            }
            this.aUS.a(mVar);
        }
    }
}
