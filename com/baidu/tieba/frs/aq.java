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
    final /* synthetic */ FrsActivity aUK;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity) {
        this.aUK = frsActivity;
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
        bsVar = this.aUK.aTU;
        if (bsVar != null) {
            switch (i) {
                case 1:
                    bsVar5 = this.aUK.aTU;
                    bsVar5.cd(true);
                    bsVar6 = this.aUK.aTU;
                    bsVar6.LM();
                    return;
                case 2:
                    bsVar2 = this.aUK.aTU;
                    bsVar2.ce(true);
                    bsVar3 = this.aUK.aTU;
                    bsVar3.LM();
                    return;
                case 3:
                    bsVar4 = this.aUK.aTU;
                    bsVar4.cc(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b2, code lost:
        if (r1.avv().size() == 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x06ad  */
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
        com.baidu.tieba.tbadkCore.data.b bVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.data.b bVar2;
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
        com.baidu.tieba.frs.b.k kVar;
        com.baidu.tieba.tbadkCore.o oVar13;
        com.baidu.tieba.frs.loadmore.a aVar3;
        com.baidu.tieba.tbadkCore.o oVar14;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.frs.b.a aVar4;
        com.baidu.tieba.tbadkCore.o oVar15;
        com.baidu.tieba.tbadkCore.o oVar16;
        com.baidu.tieba.tbadkCore.o oVar17;
        com.baidu.tieba.frs.b.k kVar2;
        com.baidu.tieba.tbadkCore.o oVar18;
        com.baidu.tieba.tbadkCore.o oVar19;
        com.baidu.tieba.tbadkCore.o oVar20;
        com.baidu.tieba.frs.b.k kVar3;
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
        this.aUK.aUt = true;
        if (aVar != null && aVar.isSuccess) {
            bsVar20 = this.aUK.aTU;
            bsVar20.LV().bV(com.baidu.tbadk.core.util.at.uG().uI());
            FrsActivity.aUb = 0L;
            FrsActivity.aUc = 0L;
            FrsActivity.aUd = 0;
        } else {
            FrsActivity.aUd = 1;
        }
        if (i == 3) {
            aVar8 = this.aUK.aUm;
            aVar8.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bsVar = this.aUK.aTU;
        bsVar.cc(false);
        if (this.aUK.Li().MN() != null) {
            this.aUK.aTW = this.aUK.Li().MN();
        }
        FrsActivity frsActivity = this.aUK;
        oVar = this.aUK.aTW;
        frsActivity.aUn = oVar.getPage().rI();
        i2 = this.aUK.aUn;
        if (i2 == 0) {
            oVar39 = this.aUK.aTW;
            if (oVar39.avv() != null) {
                oVar42 = this.aUK.aTW;
            }
            oVar40 = this.aUK.aTW;
            if (oVar40.getThreadList() != null) {
                oVar41 = this.aUK.aTW;
                if (oVar41.getThreadList().size() != 0) {
                    bsVar19 = this.aUK.aTU;
                    bsVar19.Mb();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                bsVar5 = this.aUK.aTU;
                                bsVar5.cd(false);
                                bsVar6 = this.aUK.aTU;
                                bsVar6.LM();
                                break;
                            case 2:
                                bsVar3 = this.aUK.aTU;
                                bsVar3.ce(false);
                                bsVar4 = this.aUK.aTU;
                                bsVar4.LM();
                                break;
                            case 3:
                                bVar = this.aUK.aTR;
                                if (bVar != null) {
                                    bVar2 = this.aUK.aTR;
                                    bVar2.awi();
                                }
                                oVar2 = this.aUK.aTW;
                                if (oVar2 != null) {
                                    oVar3 = this.aUK.aTW;
                                    oVar3.avM();
                                    break;
                                }
                                break;
                        }
                        FrsActivity frsActivity2 = this.aUK;
                        bsVar7 = this.aUK.aTU;
                        frsActivity2.hideLoadingView(bsVar7.getRootView());
                        bsVar8 = this.aUK.aTU;
                        bsVar8.LT();
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.aUK.aTH;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.cWT) {
                                        if (340001 == aVar.errorCode) {
                                            FrsActivity frsActivity3 = this.aUK;
                                            bsVar14 = this.aUK.aTU;
                                            frsActivity3.showNetRefreshViewNoClick(bsVar14.getRootView(), this.aUK.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            FrsActivity frsActivity4 = this.aUK;
                                            bsVar13 = this.aUK.aTU;
                                            frsActivity4.showNetRefreshView(bsVar13.getRootView(), this.aUK.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        FrsActivity frsActivity5 = this.aUK;
                                        bsVar11 = this.aUK.aTU;
                                        frsActivity5.showNetRefreshViewNoClick(bsVar11.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        FrsActivity frsActivity6 = this.aUK;
                                        bsVar10 = this.aUK.aTU;
                                        frsActivity6.showNetRefreshView(bsVar10.getRootView(), aVar.errorMsg, true);
                                    }
                                    bsVar12 = this.aUK.aTU;
                                    bsVar12.fA(8);
                                }
                            } else if (aVar != null && aVar.cWT) {
                                bsVar9 = this.aUK.aTU;
                                bsVar9.fA(0);
                                this.aUK.showToast(this.aUK.getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.aUK.aTH = true;
                            this.aUK.aTT = true;
                            bsVar15 = this.aUK.aTU;
                            bsVar15.fA(0);
                            oVar8 = this.aUK.aTW;
                            if (oVar8 != null) {
                                FrsActivity frsActivity7 = this.aUK;
                                oVar30 = this.aUK.aTW;
                                frsActivity7.aTM = oVar30.aeJ().getName();
                                FrsActivity frsActivity8 = this.aUK;
                                oVar31 = this.aUK.aTW;
                                frsActivity8.forumId = oVar31.aeJ().getId();
                                oVar32 = this.aUK.aTW;
                                if (oVar32.aeJ().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.aUK.aUk;
                                    oVar35 = this.aUK.aTW;
                                    aVar6.fT(oVar35.getUserData().getIsMem());
                                }
                                bsVar16 = this.aUK.aTU;
                                oVar33 = this.aUK.aTW;
                                ForumData aeJ = oVar33.aeJ();
                                oVar34 = this.aUK.aTW;
                                bsVar16.b(aeJ, oVar34.getUserData());
                            }
                            z3 = this.aUK.aUh;
                            if (z3) {
                                oVar24 = this.aUK.aTW;
                                if (oVar24 != null) {
                                    aVar5 = this.aUK.aUi;
                                    if (aVar5.Nc() == 1) {
                                        oVar25 = this.aUK.aTW;
                                        oVar25.avP();
                                        oVar26 = this.aUK.aTW;
                                        oVar26.avT();
                                        if (!this.aUK.Li().MZ() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                            oVar28 = this.aUK.aTW;
                                            oVar28.avS();
                                            oVar29 = this.aUK.aTW;
                                            oVar29.avR();
                                        }
                                        if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                            oVar27 = this.aUK.aTW;
                                            oVar27.aP(this.aUK.getPageContext().getPageActivity());
                                        }
                                    }
                                }
                            }
                            oVar9 = this.aUK.aTW;
                            com.baidu.tbadk.core.data.y top_notice_data = oVar9.aeJ().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                                wVar.setTitle(top_notice_data.getTitle());
                                wVar.bA(2);
                                wVar.cn(top_notice_data.sH());
                                wVar.parser_title();
                                oVar23 = this.aUK.aTW;
                                oVar23.f(wVar);
                            }
                            aVar2 = this.aUK.aUk;
                            String MY = this.aUK.Li().MY();
                            oVar10 = this.aUK.aTW;
                            aVar2.a(MY, oVar10);
                            FrsActivity.aUb = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.aUc = aVar.cWU;
                            }
                            oVar11 = this.aUK.aTW;
                            if (oVar11 != null) {
                                oVar21 = this.aUK.aTW;
                                if (oVar21.getThreadList() != null) {
                                    oVar22 = this.aUK.aTW;
                                    if (oVar22.getThreadList().size() == 0 && this.aUK.Li().getType() == 4) {
                                        this.aUK.showToast(this.aUK.getPageContext().getString(i.h.no_more_to_load));
                                        i3 = this.aUK.mPn;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.aUK;
                                            i4 = frsActivity9.mPn;
                                            frsActivity9.mPn = i4 - 1;
                                        }
                                        if (this.aUK.aLJ > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aUK.aLJ, this.aUK.Li().Iw() - this.aUK.aLJ, this.aUK.Li().Iu(), this.aUK.Li().Iv(), currentTimeMillis2 - this.aUK.Li().It());
                                            this.aUK.aLJ = -1L;
                                        }
                                        this.aUK.axy = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            oVar12 = this.aUK.aTW;
                            if (oVar12 != null) {
                                oVar19 = this.aUK.aTW;
                                if (oVar19.getUserData() != null) {
                                    oVar20 = this.aUK.aTW;
                                    if (oVar20.getUserData().isBawu()) {
                                        kVar3 = this.aUK.aUl;
                                        kVar3.setIsManager(true);
                                        oVar13 = this.aUK.aTW;
                                        if (oVar13 != null) {
                                            oVar17 = this.aUK.aTW;
                                            if (oVar17.aeJ() != null) {
                                                kVar2 = this.aUK.aUl;
                                                oVar18 = this.aUK.aTW;
                                                kVar2.cl(oVar18.aeJ().isLike() == 1);
                                            }
                                        }
                                        aVar3 = this.aUK.aUm;
                                        oVar14 = this.aUK.aTW;
                                        a = aVar3.a(true, oVar14.getThreadList());
                                        if (a != null) {
                                            oVar16 = this.aUK.aTW;
                                            oVar16.af(a);
                                        }
                                        this.aUK.KW();
                                        aVar4 = this.aUK.aUk;
                                        oVar15 = this.aUK.aTW;
                                        aVar4.cj(oVar15.avs());
                                    }
                                }
                            }
                            kVar = this.aUK.aUl;
                            kVar.setIsManager(false);
                            oVar13 = this.aUK.aTW;
                            if (oVar13 != null) {
                            }
                            aVar3 = this.aUK.aUm;
                            oVar14 = this.aUK.aTW;
                            a = aVar3.a(true, oVar14.getThreadList());
                            if (a != null) {
                            }
                            this.aUK.KW();
                            aVar4 = this.aUK.aUk;
                            oVar15 = this.aUK.aTW;
                            aVar4.cj(oVar15.avs());
                        }
                        FrsActivity frsActivity10 = this.aUK;
                        oVar4 = this.aUK.aTW;
                        frsActivity10.aTQ = oVar4.Nf();
                        if (this.aUK.aLJ > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aUK.aLJ, this.aUK.Li().Iw() - this.aUK.aLJ, this.aUK.Li().Iu(), this.aUK.Li().Iv(), currentTimeMillis3 - this.aUK.Li().It());
                            this.aUK.aLJ = -1L;
                        }
                        oVar5 = this.aUK.aTW;
                        if (oVar5 != null) {
                            oVar6 = this.aUK.aTW;
                            if (oVar6.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                oVar7 = this.aUK.aTW;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(oVar7.getUserData().getIsMem())));
                            }
                        }
                        this.aUK.axy = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar7 = this.aUK.aUm;
                    oVar36 = this.aUK.aTW;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, oVar36.getThreadList());
                    if (a2 != null) {
                        oVar37 = this.aUK.aTW;
                        oVar37.af(a2);
                        bsVar17 = this.aUK.aTU;
                        i5 = this.aUK.mPn;
                        oVar38 = this.aUK.aTW;
                        i6 = this.aUK.aUn;
                        bsVar17.a(a2, i5, oVar38, i6);
                        return;
                    }
                    return;
                }
            }
            bsVar18 = this.aUK.aTU;
            bsVar18.Mc();
            if (i != 4) {
            }
        }
        bsVar2 = this.aUK.aTU;
        bsVar2.Ma();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.aUK.Li().MY()) && !"frs_page".equals(this.aUK.Li().MY())) {
                return;
            }
            this.aUK.a(mVar);
        }
    }
}
