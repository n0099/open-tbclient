package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.tbadkCore.aa {
    final /* synthetic */ FrsActivity aJQ;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aa
    public void eG(int i) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                bfVar3 = this.aJQ.aJa;
                bfVar3.bQ(true);
                bfVar4 = this.aJQ.aJa;
                bfVar4.Ki();
                return;
            case 2:
                bfVar = this.aJQ.aJa;
                bfVar.bR(true);
                bfVar2 = this.aJQ.aJa;
                bfVar2.Ki();
                return;
            case 3:
                bfVar5 = this.aJQ.aJa;
                bfVar5.bP(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00aa, code lost:
        if (r1.akE().size() == 0) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143  */
    @Override // com.baidu.tieba.tbadkCore.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, com.baidu.tieba.tbadkCore.h hVar) {
        bf bfVar;
        com.baidu.tieba.tbadkCore.w wVar;
        int i2;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        bf bfVar7;
        bf bfVar8;
        boolean z2;
        bf bfVar9;
        bf bfVar10;
        bf bfVar11;
        bf bfVar12;
        bf bfVar13;
        bf bfVar14;
        com.baidu.tieba.frs.c.k kVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        bf bfVar15;
        com.baidu.tieba.tbadkCore.w wVar6;
        boolean z3;
        com.baidu.tieba.tbadkCore.w wVar7;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.w wVar8;
        com.baidu.tieba.tbadkCore.w wVar9;
        com.baidu.tieba.tbadkCore.w wVar10;
        com.baidu.tieba.frs.c.k kVar2;
        com.baidu.tieba.tbadkCore.w wVar11;
        com.baidu.tieba.frs.loadmore.a aVar2;
        com.baidu.tieba.tbadkCore.w wVar12;
        ArrayList<com.baidu.adp.widget.ListView.ai> a;
        com.baidu.tieba.frs.c.a aVar3;
        com.baidu.tieba.tbadkCore.w wVar13;
        com.baidu.tieba.frs.c.a aVar4;
        bf bfVar16;
        com.baidu.tieba.tbadkCore.w wVar14;
        com.baidu.tieba.tbadkCore.w wVar15;
        com.baidu.tieba.frs.c.k kVar3;
        com.baidu.tieba.tbadkCore.w wVar16;
        com.baidu.tieba.tbadkCore.w wVar17;
        com.baidu.tieba.tbadkCore.w wVar18;
        com.baidu.tieba.frs.c.k kVar4;
        com.baidu.tieba.tbadkCore.w wVar19;
        com.baidu.tieba.tbadkCore.w wVar20;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.w wVar21;
        com.baidu.tieba.tbadkCore.w wVar22;
        com.baidu.tieba.tbadkCore.w wVar23;
        com.baidu.tieba.tbadkCore.w wVar24;
        bf bfVar17;
        com.baidu.tieba.tbadkCore.w wVar25;
        com.baidu.tieba.tbadkCore.w wVar26;
        com.baidu.tieba.tbadkCore.w wVar27;
        com.baidu.tieba.tbadkCore.w wVar28;
        com.baidu.tieba.tbadkCore.w wVar29;
        com.baidu.tieba.tbadkCore.w wVar30;
        bf bfVar18;
        com.baidu.tieba.tbadkCore.w wVar31;
        com.baidu.tieba.tbadkCore.w wVar32;
        com.baidu.tieba.frs.c.a aVar5;
        com.baidu.tieba.tbadkCore.w wVar33;
        com.baidu.tieba.frs.loadmore.a aVar6;
        com.baidu.tieba.tbadkCore.w wVar34;
        com.baidu.tieba.tbadkCore.w wVar35;
        bf bfVar19;
        int i5;
        com.baidu.tieba.tbadkCore.w wVar36;
        int i6;
        com.baidu.tieba.tbadkCore.w wVar37;
        com.baidu.tieba.tbadkCore.w wVar38;
        bf bfVar20;
        com.baidu.tieba.tbadkCore.w wVar39;
        bf bfVar21;
        com.baidu.tieba.tbadkCore.w wVar40;
        com.baidu.tieba.frs.loadmore.a aVar7;
        bf bfVar22;
        if (hVar != null && hVar.isSuccess) {
            bfVar22 = this.aJQ.aJa;
            bfVar22.Kr().bG(com.baidu.tbadk.core.util.be.sY().ta());
            FrsActivity.aJj = 0L;
            FrsActivity.aJk = 0L;
            FrsActivity.aJl = 0;
        } else {
            FrsActivity.aJl = 1;
        }
        if (i == 3) {
            aVar7 = this.aJQ.aJv;
            aVar7.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bfVar = this.aJQ.aJa;
        bfVar.bP(false);
        if (this.aJQ.oi().KS() != null) {
            this.aJQ.aJd = this.aJQ.oi().KS();
        }
        FrsActivity frsActivity = this.aJQ;
        wVar = this.aJQ.aJd;
        frsActivity.aJw = wVar.XQ().ql();
        i2 = this.aJQ.aJw;
        if (i2 == 0) {
            wVar37 = this.aJQ.aJd;
            if (wVar37.akE() != null) {
                wVar40 = this.aJQ.aJd;
            }
            wVar38 = this.aJQ.aJd;
            if (wVar38.getThreadList() != null) {
                wVar39 = this.aJQ.aJd;
                if (wVar39.getThreadList().size() != 0) {
                    bfVar21 = this.aJQ.aJa;
                    bfVar21.Kx();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                bfVar5 = this.aJQ.aJa;
                                bfVar5.bQ(false);
                                bfVar6 = this.aJQ.aJa;
                                bfVar6.Ki();
                                break;
                            case 2:
                                bfVar3 = this.aJQ.aJa;
                                bfVar3.bR(false);
                                bfVar4 = this.aJQ.aJa;
                                bfVar4.Ki();
                                break;
                        }
                        FrsActivity frsActivity2 = this.aJQ;
                        bfVar7 = this.aJQ.aJa;
                        frsActivity2.hideLoadingView(bfVar7.getRootView());
                        bfVar8 = this.aJQ.aJa;
                        bfVar8.Kp();
                        if (z || (hVar != null && hVar.errorCode != 0)) {
                            z2 = this.aJQ.aIQ;
                            if (!z2) {
                                if (hVar != null) {
                                    if (hVar.ckH) {
                                        if (340001 == hVar.errorCode) {
                                            FrsActivity frsActivity3 = this.aJQ;
                                            bfVar14 = this.aJQ.aJa;
                                            frsActivity3.showNetRefreshViewNoClick(bfVar14.Ks(), this.aJQ.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), false);
                                        } else {
                                            FrsActivity frsActivity4 = this.aJQ;
                                            bfVar13 = this.aJQ.aJa;
                                            frsActivity4.showNetRefreshView(bfVar13.Ks(), this.aJQ.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), false);
                                        }
                                    } else if (340001 == hVar.errorCode) {
                                        FrsActivity frsActivity5 = this.aJQ;
                                        bfVar11 = this.aJQ.aJa;
                                        frsActivity5.showNetRefreshViewNoClick(bfVar11.Ks(), hVar.errorMsg, false);
                                    } else {
                                        FrsActivity frsActivity6 = this.aJQ;
                                        bfVar10 = this.aJQ.aJa;
                                        frsActivity6.showNetRefreshView(bfVar10.Ks(), hVar.errorMsg, false);
                                    }
                                    bfVar12 = this.aJQ.aJa;
                                    bfVar12.eP(8);
                                }
                            } else if (hVar != null && hVar.ckH) {
                                bfVar9 = this.aJQ.aJa;
                                bfVar9.eP(0);
                                this.aJQ.showToast(this.aJQ.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)));
                            }
                        } else {
                            this.aJQ.aIQ = true;
                            this.aJQ.aIZ = true;
                            bfVar15 = this.aJQ.aJa;
                            bfVar15.eP(0);
                            wVar6 = this.aJQ.aJd;
                            if (wVar6 != null) {
                                FrsActivity frsActivity7 = this.aJQ;
                                wVar28 = this.aJQ.aJd;
                                frsActivity7.aIS = wVar28.Za().getName();
                                FrsActivity frsActivity8 = this.aJQ;
                                wVar29 = this.aJQ.aJd;
                                frsActivity8.forumId = wVar29.Za().getId();
                                wVar30 = this.aJQ.aJd;
                                if (wVar30.Za().getFrsBannerData().getType() == 2) {
                                    aVar5 = this.aJQ.aJt;
                                    wVar33 = this.aJQ.aJd;
                                    aVar5.eS(wVar33.getUserData().getIsMem());
                                    this.aJQ.aJc = true;
                                }
                                bfVar18 = this.aJQ.aJa;
                                wVar31 = this.aJQ.aJd;
                                ForumData Za = wVar31.Za();
                                wVar32 = this.aJQ.aJd;
                                bfVar18.a(Za, wVar32.getUserData());
                            }
                            z3 = this.aJQ.aJp;
                            if (z3) {
                                wVar22 = this.aJQ.aJd;
                                if (wVar22 != null) {
                                    wVar23 = this.aJQ.aJd;
                                    wVar23.akY();
                                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                        wVar27 = this.aJQ.aJd;
                                        wVar27.aB(this.aJQ.getPageContext().getPageActivity());
                                    }
                                    wVar24 = this.aJQ.aJd;
                                    wVar24.ala();
                                    if (!this.aJQ.oi().KR()) {
                                        wVar26 = this.aJQ.aJd;
                                        wVar26.akZ();
                                    }
                                    bfVar17 = this.aJQ.aJa;
                                    wVar25 = this.aJQ.aJd;
                                    bfVar17.b(wVar25);
                                }
                            }
                            wVar7 = this.aJQ.aJd;
                            com.baidu.tbadk.core.data.y top_notice_data = wVar7.Za().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.w wVar41 = new com.baidu.tbadk.core.data.w();
                                wVar41.setTitle(top_notice_data.getTitle());
                                wVar41.bt(2);
                                wVar41.bU(top_notice_data.qY());
                                wVar41.parser_title();
                                wVar21 = this.aJQ.aJd;
                                wVar21.e(wVar41);
                            }
                            aVar = this.aJQ.aJt;
                            String KQ = this.aJQ.oi().KQ();
                            wVar8 = this.aJQ.aJd;
                            aVar.a(KQ, wVar8);
                            FrsActivity.aJj = (System.nanoTime() - this.startTime) / 1000000;
                            if (hVar != null) {
                                FrsActivity.aJk = hVar.ckI;
                            }
                            wVar9 = this.aJQ.aJd;
                            if (wVar9 != null) {
                                wVar19 = this.aJQ.aJd;
                                if (wVar19.getThreadList() != null) {
                                    wVar20 = this.aJQ.aJd;
                                    if (wVar20.getThreadList().size() == 0 && this.aJQ.oi().getType() == 4) {
                                        this.aJQ.showToast(this.aJQ.getPageContext().getString(com.baidu.tieba.y.no_more_to_load));
                                        i3 = this.aJQ.aIU;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.aJQ;
                                            i4 = frsActivity9.aIU;
                                            frsActivity9.aIU = i4 - 1;
                                        }
                                        if (this.aJQ.aCO > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aJQ.aCO, this.aJQ.oi().Ha() - this.aJQ.aCO, this.aJQ.oi().GY(), this.aJQ.oi().GZ(), currentTimeMillis2 - this.aJQ.oi().GX());
                                            this.aJQ.aCO = -1L;
                                        }
                                        this.aJQ.apB = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            wVar10 = this.aJQ.aJd;
                            if (wVar10 != null) {
                                wVar17 = this.aJQ.aJd;
                                if (wVar17.getUserData() != null) {
                                    wVar18 = this.aJQ.aJd;
                                    if (wVar18.getUserData().isBawu()) {
                                        kVar4 = this.aJQ.aJu;
                                        kVar4.setIsManager(true);
                                        wVar11 = this.aJQ.aJd;
                                        if (wVar11 != null) {
                                            wVar15 = this.aJQ.aJd;
                                            if (wVar15.Za() != null) {
                                                kVar3 = this.aJQ.aJu;
                                                wVar16 = this.aJQ.aJd;
                                                kVar3.bX(wVar16.Za().isLike() == 1);
                                            }
                                        }
                                        aVar2 = this.aJQ.aJv;
                                        wVar12 = this.aJQ.aJd;
                                        a = aVar2.a(true, wVar12.getThreadList());
                                        if (a != null) {
                                            wVar14 = this.aJQ.aJd;
                                            wVar14.V(a);
                                        }
                                        this.aJQ.Jw();
                                        aVar3 = this.aJQ.aJt;
                                        wVar13 = this.aJQ.aJd;
                                        aVar3.bW(wVar13.akG());
                                        aVar4 = this.aJQ.aJt;
                                        bfVar16 = this.aJQ.aJa;
                                        aVar4.b(bfVar16.getNavigationBar());
                                        this.aJQ.ok().Kv();
                                    }
                                }
                            }
                            kVar2 = this.aJQ.aJu;
                            kVar2.setIsManager(false);
                            wVar11 = this.aJQ.aJd;
                            if (wVar11 != null) {
                            }
                            aVar2 = this.aJQ.aJv;
                            wVar12 = this.aJQ.aJd;
                            a = aVar2.a(true, wVar12.getThreadList());
                            if (a != null) {
                            }
                            this.aJQ.Jw();
                            aVar3 = this.aJQ.aJt;
                            wVar13 = this.aJQ.aJd;
                            aVar3.bW(wVar13.akG());
                            aVar4 = this.aJQ.aJt;
                            bfVar16 = this.aJQ.aJa;
                            aVar4.b(bfVar16.getNavigationBar());
                            this.aJQ.ok().Kv();
                        }
                        if (this.aJQ.aCO > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aJQ.aCO, this.aJQ.oi().Ha() - this.aJQ.aCO, this.aJQ.oi().GY(), this.aJQ.oi().GZ(), currentTimeMillis3 - this.aJQ.oi().GX());
                            this.aJQ.aCO = -1L;
                        }
                        kVar = this.aJQ.aJu;
                        wVar2 = this.aJQ.aJd;
                        kVar.e(wVar2);
                        wVar3 = this.aJQ.aJd;
                        if (wVar3 != null) {
                            wVar4 = this.aJQ.aJd;
                            if (wVar4.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                wVar5 = this.aJQ.aJd;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(wVar5.getUserData().getIsMem())));
                            }
                        }
                        this.aJQ.apB = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar6 = this.aJQ.aJv;
                    wVar34 = this.aJQ.aJd;
                    ArrayList<com.baidu.adp.widget.ListView.ai> a2 = aVar6.a(false, wVar34.getThreadList());
                    if (a2 != null) {
                        wVar35 = this.aJQ.aJd;
                        wVar35.V(a2);
                        bfVar19 = this.aJQ.aJa;
                        i5 = this.aJQ.aIU;
                        wVar36 = this.aJQ.aJd;
                        i6 = this.aJQ.aJw;
                        bfVar19.a(a2, i5, wVar36, i6);
                        return;
                    }
                    return;
                }
            }
            bfVar20 = this.aJQ.aJa;
            bfVar20.Ky();
            if (i != 4) {
            }
        }
        bfVar2 = this.aJQ.aJa;
        bfVar2.Kw();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aa
    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            if (!"normal_page".equals(this.aJQ.oi().KQ()) && !"frs_page".equals(this.aJQ.oi().KQ())) {
                return;
            }
            this.aJQ.a(uVar);
        }
    }
}
