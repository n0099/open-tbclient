package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class av implements com.baidu.tieba.tbadkCore.x {
    final /* synthetic */ FrsActivity aDW;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.x
    public void eL(int i) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        bp bpVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                bpVar3 = this.aDW.aCY;
                bpVar3.bQ(true);
                bpVar4 = this.aDW.aCY;
                bpVar4.GT();
                return;
            case 2:
                bpVar = this.aDW.aCY;
                bpVar.bR(true);
                bpVar2 = this.aDW.aCY;
                bpVar2.GT();
                return;
            case 3:
                bpVar5 = this.aDW.aCY;
                bpVar5.bP(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0540  */
    @Override // com.baidu.tieba.tbadkCore.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, com.baidu.tieba.tbadkCore.h hVar) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        bp bpVar5;
        bp bpVar6;
        boolean z2;
        bp bpVar7;
        bp bpVar8;
        bp bpVar9;
        bp bpVar10;
        long j;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        long j2;
        com.baidu.tieba.tbadkCore.e eVar6;
        long j3;
        com.baidu.tieba.tbadkCore.e eVar7;
        com.baidu.tieba.tbadkCore.e eVar8;
        com.baidu.tieba.tbadkCore.e eVar9;
        bp bpVar11;
        com.baidu.tieba.tbadkCore.e eVar10;
        boolean z3;
        com.baidu.tieba.tbadkCore.e eVar11;
        String str;
        String str2;
        String str3;
        bp bpVar12;
        com.baidu.tieba.tbadkCore.e eVar12;
        AdapterView.OnItemClickListener onItemClickListener;
        bp bpVar13;
        com.baidu.tieba.tbadkCore.e eVar13;
        com.baidu.tieba.tbadkCore.e eVar14;
        com.baidu.tieba.tbadkCore.e eVar15;
        com.baidu.tieba.tbadkCore.e eVar16;
        bp bpVar14;
        com.baidu.tieba.tbadkCore.e eVar17;
        com.baidu.tieba.tbadkCore.e eVar18;
        bp bpVar15;
        bp bpVar16;
        bp bpVar17;
        bp bpVar18;
        bp bpVar19;
        bp bpVar20;
        bp bpVar21;
        bp bpVar22;
        bp bpVar23;
        com.baidu.tieba.tbadkCore.e eVar19;
        bp bpVar24;
        com.baidu.tieba.tbadkCore.e eVar20;
        com.baidu.tieba.tbadkCore.e eVar21;
        com.baidu.tieba.tbadkCore.e eVar22;
        bp bpVar25;
        com.baidu.tieba.tbadkCore.e eVar23;
        com.baidu.tieba.tbadkCore.e eVar24;
        int i2;
        int i3;
        long j4;
        long j5;
        com.baidu.tieba.tbadkCore.e eVar25;
        long j6;
        com.baidu.tieba.tbadkCore.e eVar26;
        com.baidu.tieba.tbadkCore.e eVar27;
        com.baidu.tieba.tbadkCore.e eVar28;
        int i4;
        bp bpVar26;
        com.baidu.tieba.tbadkCore.e eVar29;
        com.baidu.tieba.tbadkCore.e eVar30;
        com.baidu.tieba.tbadkCore.e eVar31;
        com.baidu.tieba.tbadkCore.e eVar32;
        com.baidu.tieba.tbadkCore.e eVar33;
        com.baidu.tieba.tbadkCore.e eVar34;
        com.baidu.tieba.tbadkCore.e eVar35;
        com.baidu.tieba.tbadkCore.e eVar36;
        com.baidu.tieba.tbadkCore.e eVar37;
        boolean z4;
        com.baidu.tieba.tbadkCore.e eVar38;
        com.baidu.tieba.tbadkCore.e eVar39;
        bp bpVar27;
        com.baidu.tieba.tbadkCore.e eVar40;
        com.baidu.tieba.tbadkCore.e eVar41;
        bp bpVar28;
        if (hVar != null && hVar.isSuccess) {
            bpVar28 = this.aDW.aCY;
            bpVar28.Hl().bD(com.baidu.tbadk.core.util.bg.pI().pK());
            FrsActivity.aDc = 0L;
            FrsActivity.aDd = 0L;
            FrsActivity.aDe = 0;
        } else {
            FrsActivity.aDe = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bpVar = this.aDW.aCY;
        bpVar.bP(false);
        switch (i) {
            case 1:
                bpVar4 = this.aDW.aCY;
                bpVar4.bQ(false);
                bpVar5 = this.aDW.aCY;
                bpVar5.GT();
                break;
            case 2:
                bpVar2 = this.aDW.aCY;
                bpVar2.bR(false);
                bpVar3 = this.aDW.aCY;
                bpVar3.GT();
                break;
        }
        FrsActivity frsActivity = this.aDW;
        bpVar6 = this.aDW.aCY;
        frsActivity.hideLoadingView(bpVar6.getRootView());
        if (z || (hVar != null && hVar.errorCode != 0)) {
            z2 = this.aDW.aCM;
            if (!z2) {
                if (hVar != null) {
                    if (hVar.bTY) {
                        FrsActivity frsActivity2 = this.aDW;
                        bpVar10 = this.aDW.aCY;
                        frsActivity2.showNetRefreshView(bpVar10.getRootView(), this.aDW.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), true);
                    } else {
                        FrsActivity frsActivity3 = this.aDW;
                        bpVar8 = this.aDW.aCY;
                        frsActivity3.showNetRefreshView(bpVar8.getRootView(), hVar.errorMsg, true);
                    }
                    bpVar9 = this.aDW.aCY;
                    bpVar9.fa(8);
                }
            } else if (hVar != null && hVar.bTY) {
                bpVar7 = this.aDW.aCY;
                bpVar7.fa(0);
                this.aDW.showToast(this.aDW.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)));
            }
        } else {
            bpVar11 = this.aDW.aCY;
            bpVar11.fa(0);
            eVar10 = this.aDW.aDi;
            if (eVar10 != null) {
                eVar37 = this.aDW.aDi;
                if (eVar37.aeP().aeU() == 1) {
                    this.aDW.mPageType = "frs_page";
                } else {
                    this.aDW.mPageType = "normal_page";
                }
                z4 = this.aDW.aDg;
                if (z4) {
                    this.aDW.mPageType = "good_page";
                }
                FrsActivity frsActivity4 = this.aDW;
                eVar38 = this.aDW.aDi;
                frsActivity4.aCQ = eVar38.aeN().getName();
                FrsActivity frsActivity5 = this.aDW;
                eVar39 = this.aDW.aDi;
                frsActivity5.forumId = eVar39.aeN().getId();
                bpVar27 = this.aDW.aCY;
                eVar40 = this.aDW.aDi;
                ForumData aeN = eVar40.aeN();
                eVar41 = this.aDW.aDi;
                bpVar27.a(aeN, eVar41.getUserData());
            }
            z3 = this.aDW.aDu;
            if (z3) {
                eVar32 = this.aDW.aDi;
                if (eVar32 != null) {
                    eVar33 = this.aDW.aDi;
                    eVar33.aeS();
                    if (TbadkCoreApplication.m255getInst().isRecAppExist()) {
                        eVar36 = this.aDW.aDi;
                        eVar36.av(this.aDW.getPageContext().getPageActivity());
                    }
                    eVar34 = this.aDW.aDi;
                    eVar34.aeT();
                    FrsActivity frsActivity6 = this.aDW;
                    eVar35 = this.aDW.aDi;
                    frsActivity6.b(eVar35);
                }
            }
            eVar11 = this.aDW.aDi;
            com.baidu.tbadk.core.data.z top_notice_data = eVar11.aeN().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.setTitle(top_notice_data.getTitle());
                xVar.bu(2);
                xVar.bQ(top_notice_data.nR());
                xVar.parser_title();
                eVar31 = this.aDW.aDi;
                eVar31.d(xVar);
            }
            str = this.aDW.mPageType;
            if (str.equals("frs_page")) {
                bpVar26 = this.aDW.aCY;
                eVar29 = this.aDW.aDi;
                int isMem = eVar29.getUserData().getIsMem();
                eVar30 = this.aDW.aDi;
                bpVar26.N(isMem, eVar30.aeN().isLike());
            } else {
                str2 = this.aDW.mPageType;
                if (str2.equals("normal_page")) {
                    bpVar13 = this.aDW.aCY;
                    eVar13 = this.aDW.aDi;
                    int isMem2 = eVar13.getUserData().getIsMem();
                    eVar14 = this.aDW.aDi;
                    bpVar13.M(isMem2, eVar14.aeN().isLike());
                } else {
                    str3 = this.aDW.mPageType;
                    if (str3.equals("good_page")) {
                        bpVar12 = this.aDW.aCY;
                        eVar12 = this.aDW.aDi;
                        ArrayList<com.baidu.tbadk.core.data.k> good_classify = eVar12.aeN().getGood_classify();
                        onItemClickListener = this.aDW.aDN;
                        bpVar12.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.aDc = (System.nanoTime() - this.startTime) / 1000000;
            if (hVar != null) {
                FrsActivity.aDd = hVar.bTZ;
            }
            eVar15 = this.aDW.aDi;
            if (eVar15 != null) {
                eVar23 = this.aDW.aDi;
                if (eVar23.aeO() != null) {
                    eVar24 = this.aDW.aDi;
                    if (eVar24.aeO().size() == 0) {
                        i2 = this.aDW.mType;
                        if (i2 == 1) {
                            this.aDW.showToast(this.aDW.getPageContext().getString(com.baidu.tieba.z.no_more_to_load));
                            i3 = this.aDW.aCS;
                            if (i3 > 1) {
                                FrsActivity frsActivity7 = this.aDW;
                                i4 = frsActivity7.aCS;
                                frsActivity7.aCS = i4 - 1;
                            }
                            j4 = this.aDW.aDp;
                            if (j4 > -1) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                j5 = this.aDW.aDp;
                                eVar25 = this.aDW.aDi;
                                long UA = eVar25.UA();
                                j6 = this.aDW.aDp;
                                long j7 = UA - j6;
                                eVar26 = this.aDW.aDi;
                                long Uy = eVar26.Uy();
                                eVar27 = this.aDW.aDi;
                                long Uz = eVar27.Uz();
                                eVar28 = this.aDW.aDi;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j5, j7, Uy, Uz, currentTimeMillis2 - eVar28.Ux());
                                this.aDW.aDp = -1L;
                            }
                            this.aDW.agS = System.currentTimeMillis() - currentTimeMillis;
                            return;
                        }
                    }
                }
            }
            eVar16 = this.aDW.aDi;
            if (eVar16 != null) {
                eVar21 = this.aDW.aDi;
                if (eVar21.getUserData() != null) {
                    eVar22 = this.aDW.aDi;
                    if (eVar22.getUserData().isBawu()) {
                        bpVar25 = this.aDW.aCY;
                        bpVar25.setIsManager(true);
                        eVar17 = this.aDW.aDi;
                        if (eVar17 != null) {
                            eVar19 = this.aDW.aDi;
                            if (eVar19.aeN() != null) {
                                bpVar24 = this.aDW.aCY;
                                eVar20 = this.aDW.aDi;
                                bpVar24.bU(eVar20.aeN().isLike() == 1);
                            }
                        }
                        this.aDW.Gb();
                        eVar18 = this.aDW.aDi;
                        if (!eVar18.aeM()) {
                            bpVar20 = this.aDW.aCY;
                            if (bpVar20.GQ() != null) {
                                bpVar23 = this.aDW.aCY;
                                bpVar23.GQ().HH();
                            }
                            bpVar21 = this.aDW.aCY;
                            if (bpVar21.GR() != null) {
                                bpVar22 = this.aDW.aCY;
                                bpVar22.GR().HH();
                            }
                        } else {
                            bpVar15 = this.aDW.aCY;
                            if (bpVar15.GQ() != null) {
                                bpVar18 = this.aDW.aCY;
                                bpVar18.GQ().HG();
                            }
                            bpVar16 = this.aDW.aCY;
                            if (bpVar16.GR() != null) {
                                bpVar17 = this.aDW.aCY;
                                bpVar17.GR().HG();
                            }
                        }
                        bpVar19 = this.aDW.aCY;
                        bpVar19.GC();
                    }
                }
            }
            bpVar14 = this.aDW.aCY;
            bpVar14.setIsManager(false);
            eVar17 = this.aDW.aDi;
            if (eVar17 != null) {
            }
            this.aDW.Gb();
            eVar18 = this.aDW.aDi;
            if (!eVar18.aeM()) {
            }
            bpVar19 = this.aDW.aCY;
            bpVar19.GC();
        }
        this.aDW.aCZ = null;
        j = this.aDW.aDp;
        if (j > -1) {
            long currentTimeMillis3 = System.currentTimeMillis();
            j2 = this.aDW.aDp;
            eVar6 = this.aDW.aDi;
            long UA2 = eVar6.UA();
            j3 = this.aDW.aDp;
            long j8 = UA2 - j3;
            eVar7 = this.aDW.aDi;
            long Uy2 = eVar7.Uy();
            eVar8 = this.aDW.aDi;
            long Uz2 = eVar8.Uz();
            eVar9 = this.aDW.aDi;
            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - j2, j8, Uy2, Uz2, currentTimeMillis3 - eVar9.Ux());
            this.aDW.aDp = -1L;
        }
        FrsActivity frsActivity8 = this.aDW;
        eVar = this.aDW.aDi;
        frsActivity8.a(eVar);
        eVar2 = this.aDW.aDi;
        this.aDW.g(Boolean.valueOf(eVar2.mR().isIfvoice()));
        eVar3 = this.aDW.aDi;
        if (eVar3 != null) {
            eVar4 = this.aDW.aDi;
            if (eVar4.getUserData() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                eVar5 = this.aDW.aDi;
                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(eVar5.getUserData().getIsMem())));
            }
        }
        this.aDW.agS = System.currentTimeMillis() - currentTimeMillis;
        System.gc();
    }

    @Override // com.baidu.tieba.tbadkCore.x
    public void d(com.baidu.tieba.tbadkCore.e eVar) {
        String str;
        String str2;
        if (eVar != null) {
            str = this.aDW.mPageType;
            if (!str.equals("normal_page")) {
                str2 = this.aDW.mPageType;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.aDW.c(eVar);
        }
    }
}
