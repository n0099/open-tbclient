package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ah implements com.baidu.tieba.tbadkCore.q {
    private long startTime = 0;
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void fg(int i) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                blVar3 = this.this$0.aUw;
                blVar3.cb(true);
                blVar4 = this.this$0.aUw;
                blVar4.Ma();
                return;
            case 2:
                blVar = this.this$0.aUw;
                blVar.cc(true);
                blVar2 = this.this$0.aUw;
                blVar2.Ma();
                return;
            case 3:
                blVar5 = this.this$0.aUw;
                blVar5.ca(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00aa, code lost:
        if (r1.aoW().size() == 0) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143  */
    @Override // com.baidu.tieba.tbadkCore.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, d.a aVar) {
        bl blVar;
        com.baidu.tieba.tbadkCore.n nVar;
        int i2;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        boolean z2;
        bl blVar9;
        bl blVar10;
        bl blVar11;
        bl blVar12;
        bl blVar13;
        bl blVar14;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        com.baidu.tieba.tbadkCore.n nVar4;
        bl blVar15;
        com.baidu.tieba.tbadkCore.n nVar5;
        boolean z3;
        com.baidu.tieba.tbadkCore.n nVar6;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.tbadkCore.n nVar7;
        com.baidu.tieba.tbadkCore.n nVar8;
        com.baidu.tieba.tbadkCore.n nVar9;
        com.baidu.tieba.frs.c.k kVar;
        com.baidu.tieba.tbadkCore.n nVar10;
        com.baidu.tieba.frs.loadmore.a aVar3;
        com.baidu.tieba.tbadkCore.n nVar11;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.frs.c.a aVar4;
        com.baidu.tieba.tbadkCore.n nVar12;
        com.baidu.tieba.tbadkCore.n nVar13;
        com.baidu.tieba.tbadkCore.n nVar14;
        com.baidu.tieba.frs.c.k kVar2;
        com.baidu.tieba.tbadkCore.n nVar15;
        com.baidu.tieba.tbadkCore.n nVar16;
        com.baidu.tieba.tbadkCore.n nVar17;
        com.baidu.tieba.frs.c.k kVar3;
        com.baidu.tieba.tbadkCore.n nVar18;
        com.baidu.tieba.tbadkCore.n nVar19;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.n nVar20;
        com.baidu.tieba.tbadkCore.n nVar21;
        com.baidu.tieba.frs.b.a aVar5;
        com.baidu.tieba.tbadkCore.n nVar22;
        com.baidu.tieba.tbadkCore.n nVar23;
        bl blVar16;
        com.baidu.tieba.tbadkCore.n nVar24;
        com.baidu.tieba.tbadkCore.n nVar25;
        com.baidu.tieba.tbadkCore.n nVar26;
        com.baidu.tieba.tbadkCore.n nVar27;
        com.baidu.tieba.tbadkCore.n nVar28;
        com.baidu.tieba.tbadkCore.n nVar29;
        bl blVar17;
        com.baidu.tieba.tbadkCore.n nVar30;
        com.baidu.tieba.tbadkCore.n nVar31;
        com.baidu.tieba.frs.c.a aVar6;
        com.baidu.tieba.tbadkCore.n nVar32;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.n nVar33;
        com.baidu.tieba.tbadkCore.n nVar34;
        bl blVar18;
        int i5;
        com.baidu.tieba.tbadkCore.n nVar35;
        int i6;
        com.baidu.tieba.tbadkCore.n nVar36;
        com.baidu.tieba.tbadkCore.n nVar37;
        bl blVar19;
        com.baidu.tieba.tbadkCore.n nVar38;
        bl blVar20;
        com.baidu.tieba.tbadkCore.n nVar39;
        com.baidu.tieba.frs.loadmore.a aVar8;
        bl blVar21;
        if (aVar != null && aVar.isSuccess) {
            blVar21 = this.this$0.aUw;
            blVar21.Mj().bT(com.baidu.tbadk.core.util.ar.uE().uG());
            FrsActivity.aUD = 0L;
            FrsActivity.aUE = 0L;
            FrsActivity.aUF = 0;
        } else {
            FrsActivity.aUF = 1;
        }
        if (i == 3) {
            aVar8 = this.this$0.aUO;
            aVar8.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        blVar = this.this$0.aUw;
        blVar.ca(false);
        if (this.this$0.Lz().MS() != null) {
            this.this$0.aUy = this.this$0.Lz().MS();
        }
        FrsActivity frsActivity = this.this$0;
        nVar = this.this$0.aUy;
        frsActivity.aUP = nVar.getPage().rT();
        i2 = this.this$0.aUP;
        if (i2 == 0) {
            nVar36 = this.this$0.aUy;
            if (nVar36.aoW() != null) {
                nVar39 = this.this$0.aUy;
            }
            nVar37 = this.this$0.aUy;
            if (nVar37.getThreadList() != null) {
                nVar38 = this.this$0.aUy;
                if (nVar38.getThreadList().size() != 0) {
                    blVar20 = this.this$0.aUw;
                    blVar20.Mp();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                blVar5 = this.this$0.aUw;
                                blVar5.cb(false);
                                blVar6 = this.this$0.aUw;
                                blVar6.Ma();
                                break;
                            case 2:
                                blVar3 = this.this$0.aUw;
                                blVar3.cc(false);
                                blVar4 = this.this$0.aUw;
                                blVar4.Ma();
                                break;
                        }
                        FrsActivity frsActivity2 = this.this$0;
                        blVar7 = this.this$0.aUw;
                        frsActivity2.hideLoadingView(blVar7.getRootView());
                        blVar8 = this.this$0.aUw;
                        blVar8.Mh();
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.this$0.aUm;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.cGF) {
                                        if (340001 == aVar.errorCode) {
                                            FrsActivity frsActivity3 = this.this$0;
                                            blVar14 = this.this$0.aUw;
                                            frsActivity3.showNetRefreshViewNoClick(blVar14.getRootView(), this.this$0.getPageContext().getResources().getString(i.C0057i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            FrsActivity frsActivity4 = this.this$0;
                                            blVar13 = this.this$0.aUw;
                                            frsActivity4.showNetRefreshView(blVar13.getRootView(), this.this$0.getPageContext().getResources().getString(i.C0057i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        FrsActivity frsActivity5 = this.this$0;
                                        blVar11 = this.this$0.aUw;
                                        frsActivity5.showNetRefreshViewNoClick(blVar11.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        FrsActivity frsActivity6 = this.this$0;
                                        blVar10 = this.this$0.aUw;
                                        frsActivity6.showNetRefreshView(blVar10.getRootView(), aVar.errorMsg, true);
                                    }
                                    blVar12 = this.this$0.aUw;
                                    blVar12.fq(8);
                                }
                            } else if (aVar != null && aVar.cGF) {
                                blVar9 = this.this$0.aUw;
                                blVar9.fq(0);
                                this.this$0.showToast(this.this$0.getPageContext().getResources().getString(i.C0057i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.this$0.aUm = true;
                            this.this$0.aUv = true;
                            blVar15 = this.this$0.aUw;
                            blVar15.fq(0);
                            nVar5 = this.this$0.aUy;
                            if (nVar5 != null) {
                                FrsActivity frsActivity7 = this.this$0;
                                nVar27 = this.this$0.aUy;
                                frsActivity7.aUq = nVar27.acG().getName();
                                FrsActivity frsActivity8 = this.this$0;
                                nVar28 = this.this$0.aUy;
                                frsActivity8.forumId = nVar28.acG().getId();
                                nVar29 = this.this$0.aUy;
                                if (nVar29.acG().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.this$0.aUM;
                                    nVar32 = this.this$0.aUy;
                                    aVar6.fF(nVar32.getUserData().getIsMem());
                                }
                                blVar17 = this.this$0.aUw;
                                nVar30 = this.this$0.aUy;
                                ForumData acG = nVar30.acG();
                                nVar31 = this.this$0.aUy;
                                blVar17.b(acG, nVar31.getUserData());
                            }
                            z3 = this.this$0.aUJ;
                            if (z3) {
                                nVar21 = this.this$0.aUy;
                                if (nVar21 != null) {
                                    aVar5 = this.this$0.aUK;
                                    if (aVar5.Ng() == 1) {
                                        nVar22 = this.this$0.aUy;
                                        nVar22.apk();
                                        if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                            nVar26 = this.this$0.aUy;
                                            nVar26.aN(this.this$0.getPageContext().getPageActivity());
                                        }
                                        nVar23 = this.this$0.aUy;
                                        nVar23.apm();
                                        if (!this.this$0.Lz().Nd()) {
                                            nVar25 = this.this$0.aUy;
                                            nVar25.apl();
                                        }
                                        blVar16 = this.this$0.aUw;
                                        nVar24 = this.this$0.aUy;
                                        blVar16.b(nVar24);
                                    }
                                }
                            }
                            nVar6 = this.this$0.aUy;
                            com.baidu.tbadk.core.data.x top_notice_data = nVar6.acG().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.v vVar = new com.baidu.tbadk.core.data.v();
                                vVar.setTitle(top_notice_data.getTitle());
                                vVar.bz(2);
                                vVar.ch(top_notice_data.sI());
                                vVar.parser_title();
                                nVar20 = this.this$0.aUy;
                                nVar20.e(vVar);
                            }
                            aVar2 = this.this$0.aUM;
                            String Nc = this.this$0.Lz().Nc();
                            nVar7 = this.this$0.aUy;
                            aVar2.a(Nc, nVar7);
                            FrsActivity.aUD = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.aUE = aVar.cGG;
                            }
                            nVar8 = this.this$0.aUy;
                            if (nVar8 != null) {
                                nVar18 = this.this$0.aUy;
                                if (nVar18.getThreadList() != null) {
                                    nVar19 = this.this$0.aUy;
                                    if (nVar19.getThreadList().size() == 0 && this.this$0.Lz().getType() == 4) {
                                        this.this$0.showToast(this.this$0.getPageContext().getString(i.C0057i.no_more_to_load));
                                        i3 = this.this$0.mPn;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.this$0;
                                            i4 = frsActivity9.mPn;
                                            frsActivity9.mPn = i4 - 1;
                                        }
                                        if (this.this$0.aMq > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.this$0.aMq, this.this$0.Lz().IQ() - this.this$0.aMq, this.this$0.Lz().IO(), this.this$0.Lz().IP(), currentTimeMillis2 - this.this$0.Lz().IN());
                                            this.this$0.aMq = -1L;
                                        }
                                        this.this$0.axq = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            nVar9 = this.this$0.aUy;
                            if (nVar9 != null) {
                                nVar16 = this.this$0.aUy;
                                if (nVar16.getUserData() != null) {
                                    nVar17 = this.this$0.aUy;
                                    if (nVar17.getUserData().isBawu()) {
                                        kVar3 = this.this$0.aUN;
                                        kVar3.setIsManager(true);
                                        nVar10 = this.this$0.aUy;
                                        if (nVar10 != null) {
                                            nVar14 = this.this$0.aUy;
                                            if (nVar14.acG() != null) {
                                                kVar2 = this.this$0.aUN;
                                                nVar15 = this.this$0.aUy;
                                                kVar2.cj(nVar15.acG().isLike() == 1);
                                            }
                                        }
                                        aVar3 = this.this$0.aUO;
                                        nVar11 = this.this$0.aUy;
                                        a = aVar3.a(true, nVar11.getThreadList());
                                        if (a != null) {
                                            nVar13 = this.this$0.aUy;
                                            nVar13.X(a);
                                        }
                                        this.this$0.Lp();
                                        aVar4 = this.this$0.aUM;
                                        nVar12 = this.this$0.aUy;
                                        aVar4.ch(nVar12.aoT());
                                    }
                                }
                            }
                            kVar = this.this$0.aUN;
                            kVar.setIsManager(false);
                            nVar10 = this.this$0.aUy;
                            if (nVar10 != null) {
                            }
                            aVar3 = this.this$0.aUO;
                            nVar11 = this.this$0.aUy;
                            a = aVar3.a(true, nVar11.getThreadList());
                            if (a != null) {
                            }
                            this.this$0.Lp();
                            aVar4 = this.this$0.aUM;
                            nVar12 = this.this$0.aUy;
                            aVar4.ch(nVar12.aoT());
                        }
                        if (this.this$0.aMq > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.this$0.aMq, this.this$0.Lz().IQ() - this.this$0.aMq, this.this$0.Lz().IO(), this.this$0.Lz().IP(), currentTimeMillis3 - this.this$0.Lz().IN());
                            this.this$0.aMq = -1L;
                        }
                        nVar2 = this.this$0.aUy;
                        if (nVar2 != null) {
                            nVar3 = this.this$0.aUy;
                            if (nVar3.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                nVar4 = this.this$0.aUy;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(nVar4.getUserData().getIsMem())));
                            }
                        }
                        this.this$0.axq = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar7 = this.this$0.aUO;
                    nVar33 = this.this$0.aUy;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, nVar33.getThreadList());
                    if (a2 != null) {
                        nVar34 = this.this$0.aUy;
                        nVar34.X(a2);
                        blVar18 = this.this$0.aUw;
                        i5 = this.this$0.mPn;
                        nVar35 = this.this$0.aUy;
                        i6 = this.this$0.aUP;
                        blVar18.a(a2, i5, nVar35, i6);
                        return;
                    }
                    return;
                }
            }
            blVar19 = this.this$0.aUw;
            blVar19.Mq();
            if (i != 4) {
            }
        }
        blVar2 = this.this$0.aUw;
        blVar2.Mo();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.this$0.Lz().Nc()) && !"frs_page".equals(this.this$0.Lz().Nc())) {
                return;
            }
            this.this$0.a(lVar);
        }
    }
}
