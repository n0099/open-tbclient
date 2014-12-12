package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class aw implements com.baidu.tieba.tbadkCore.x {
    final /* synthetic */ FrsActivity aCV;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.x
    public void eF(int i) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                bqVar3 = this.aCV.aBX;
                bqVar3.bN(true);
                bqVar4 = this.aCV.aBX;
                bqVar4.Gw();
                return;
            case 2:
                bqVar = this.aCV.aBX;
                bqVar.bO(true);
                bqVar2 = this.aCV.aBX;
                bqVar2.Gw();
                return;
            case 3:
                bqVar5 = this.aCV.aBX;
                bqVar5.bM(true);
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
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        boolean z2;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        bq bqVar10;
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
        bq bqVar11;
        com.baidu.tieba.tbadkCore.e eVar10;
        boolean z3;
        com.baidu.tieba.tbadkCore.e eVar11;
        String str;
        String str2;
        String str3;
        bq bqVar12;
        com.baidu.tieba.tbadkCore.e eVar12;
        AdapterView.OnItemClickListener onItemClickListener;
        bq bqVar13;
        com.baidu.tieba.tbadkCore.e eVar13;
        com.baidu.tieba.tbadkCore.e eVar14;
        com.baidu.tieba.tbadkCore.e eVar15;
        com.baidu.tieba.tbadkCore.e eVar16;
        bq bqVar14;
        com.baidu.tieba.tbadkCore.e eVar17;
        com.baidu.tieba.tbadkCore.e eVar18;
        bq bqVar15;
        bq bqVar16;
        bq bqVar17;
        bq bqVar18;
        bq bqVar19;
        bq bqVar20;
        bq bqVar21;
        bq bqVar22;
        bq bqVar23;
        com.baidu.tieba.tbadkCore.e eVar19;
        bq bqVar24;
        com.baidu.tieba.tbadkCore.e eVar20;
        com.baidu.tieba.tbadkCore.e eVar21;
        com.baidu.tieba.tbadkCore.e eVar22;
        bq bqVar25;
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
        bq bqVar26;
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
        bq bqVar27;
        com.baidu.tieba.tbadkCore.e eVar40;
        com.baidu.tieba.tbadkCore.e eVar41;
        bq bqVar28;
        if (hVar != null && hVar.isSuccess) {
            bqVar28 = this.aCV.aBX;
            bqVar28.GO().bA(com.baidu.tbadk.core.util.bb.px().pz());
            FrsActivity.aCb = 0L;
            FrsActivity.aCc = 0L;
            FrsActivity.aCd = 0;
        } else {
            FrsActivity.aCd = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bqVar = this.aCV.aBX;
        bqVar.bM(false);
        switch (i) {
            case 1:
                bqVar4 = this.aCV.aBX;
                bqVar4.bN(false);
                bqVar5 = this.aCV.aBX;
                bqVar5.Gw();
                break;
            case 2:
                bqVar2 = this.aCV.aBX;
                bqVar2.bO(false);
                bqVar3 = this.aCV.aBX;
                bqVar3.Gw();
                break;
        }
        FrsActivity frsActivity = this.aCV;
        bqVar6 = this.aCV.aBX;
        frsActivity.hideLoadingView(bqVar6.getRootView());
        if (z || (hVar != null && hVar.errorCode != 0)) {
            z2 = this.aCV.aBL;
            if (!z2) {
                if (hVar != null) {
                    if (hVar.bSk) {
                        FrsActivity frsActivity2 = this.aCV;
                        bqVar10 = this.aCV.aBX;
                        frsActivity2.showNetRefreshView(bqVar10.getRootView(), this.aCV.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), true);
                    } else {
                        FrsActivity frsActivity3 = this.aCV;
                        bqVar8 = this.aCV.aBX;
                        frsActivity3.showNetRefreshView(bqVar8.getRootView(), hVar.errorMsg, true);
                    }
                    bqVar9 = this.aCV.aBX;
                    bqVar9.eU(8);
                }
            } else if (hVar != null && hVar.bSk) {
                bqVar7 = this.aCV.aBX;
                bqVar7.eU(0);
                this.aCV.showToast(this.aCV.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)));
            }
        } else {
            bqVar11 = this.aCV.aBX;
            bqVar11.eU(0);
            eVar10 = this.aCV.aCh;
            if (eVar10 != null) {
                eVar37 = this.aCV.aCh;
                if (eVar37.ael().aeq() == 1) {
                    this.aCV.mPageType = "frs_page";
                } else {
                    this.aCV.mPageType = "normal_page";
                }
                z4 = this.aCV.aCf;
                if (z4) {
                    this.aCV.mPageType = "good_page";
                }
                FrsActivity frsActivity4 = this.aCV;
                eVar38 = this.aCV.aCh;
                frsActivity4.aBP = eVar38.aej().getName();
                FrsActivity frsActivity5 = this.aCV;
                eVar39 = this.aCV.aCh;
                frsActivity5.forumId = eVar39.aej().getId();
                bqVar27 = this.aCV.aBX;
                eVar40 = this.aCV.aCh;
                ForumData aej = eVar40.aej();
                eVar41 = this.aCV.aCh;
                bqVar27.a(aej, eVar41.getUserData());
            }
            z3 = this.aCV.aCt;
            if (z3) {
                eVar32 = this.aCV.aCh;
                if (eVar32 != null) {
                    eVar33 = this.aCV.aCh;
                    eVar33.aeo();
                    if (TbadkCoreApplication.m255getInst().isRecAppExist()) {
                        eVar36 = this.aCV.aCh;
                        eVar36.au(this.aCV.getPageContext().getPageActivity());
                    }
                    eVar34 = this.aCV.aCh;
                    eVar34.aep();
                    FrsActivity frsActivity6 = this.aCV;
                    eVar35 = this.aCV.aCh;
                    frsActivity6.b(eVar35);
                }
            }
            eVar11 = this.aCV.aCh;
            com.baidu.tbadk.core.data.y top_notice_data = eVar11.aej().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                wVar.setTitle(top_notice_data.getTitle());
                wVar.bp(2);
                wVar.bS(top_notice_data.nO());
                wVar.parser_title();
                eVar31 = this.aCV.aCh;
                eVar31.d(wVar);
            }
            str = this.aCV.mPageType;
            if (str.equals("frs_page")) {
                bqVar26 = this.aCV.aBX;
                eVar29 = this.aCV.aCh;
                int isMem = eVar29.getUserData().getIsMem();
                eVar30 = this.aCV.aCh;
                bqVar26.M(isMem, eVar30.aej().isLike());
            } else {
                str2 = this.aCV.mPageType;
                if (str2.equals("normal_page")) {
                    bqVar13 = this.aCV.aBX;
                    eVar13 = this.aCV.aCh;
                    int isMem2 = eVar13.getUserData().getIsMem();
                    eVar14 = this.aCV.aCh;
                    bqVar13.L(isMem2, eVar14.aej().isLike());
                } else {
                    str3 = this.aCV.mPageType;
                    if (str3.equals("good_page")) {
                        bqVar12 = this.aCV.aBX;
                        eVar12 = this.aCV.aCh;
                        ArrayList<com.baidu.tbadk.core.data.j> good_classify = eVar12.aej().getGood_classify();
                        onItemClickListener = this.aCV.aCM;
                        bqVar12.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.aCb = (System.nanoTime() - this.startTime) / 1000000;
            if (hVar != null) {
                FrsActivity.aCc = hVar.bSl;
            }
            eVar15 = this.aCV.aCh;
            if (eVar15 != null) {
                eVar23 = this.aCV.aCh;
                if (eVar23.aek() != null) {
                    eVar24 = this.aCV.aCh;
                    if (eVar24.aek().size() == 0) {
                        i2 = this.aCV.mType;
                        if (i2 == 1) {
                            this.aCV.showToast(this.aCV.getPageContext().getString(com.baidu.tieba.z.no_more_to_load));
                            i3 = this.aCV.aBR;
                            if (i3 > 1) {
                                FrsActivity frsActivity7 = this.aCV;
                                i4 = frsActivity7.aBR;
                                frsActivity7.aBR = i4 - 1;
                            }
                            j4 = this.aCV.aCo;
                            if (j4 > -1) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                j5 = this.aCV.aCo;
                                eVar25 = this.aCV.aCh;
                                long Uc = eVar25.Uc();
                                j6 = this.aCV.aCo;
                                long j7 = Uc - j6;
                                eVar26 = this.aCV.aCh;
                                long Ua = eVar26.Ua();
                                eVar27 = this.aCV.aCh;
                                long Ub = eVar27.Ub();
                                eVar28 = this.aCV.aCh;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j5, j7, Ua, Ub, currentTimeMillis2 - eVar28.TZ());
                                this.aCV.aCo = -1L;
                            }
                            this.aCV.agu = System.currentTimeMillis() - currentTimeMillis;
                            return;
                        }
                    }
                }
            }
            eVar16 = this.aCV.aCh;
            if (eVar16 != null) {
                eVar21 = this.aCV.aCh;
                if (eVar21.getUserData() != null) {
                    eVar22 = this.aCV.aCh;
                    if (eVar22.getUserData().isBawu()) {
                        bqVar25 = this.aCV.aBX;
                        bqVar25.setIsManager(true);
                        eVar17 = this.aCV.aCh;
                        if (eVar17 != null) {
                            eVar19 = this.aCV.aCh;
                            if (eVar19.aej() != null) {
                                bqVar24 = this.aCV.aBX;
                                eVar20 = this.aCV.aCh;
                                bqVar24.bR(eVar20.aej().isLike() == 1);
                            }
                        }
                        this.aCV.FD();
                        eVar18 = this.aCV.aCh;
                        if (!eVar18.aei()) {
                            bqVar20 = this.aCV.aBX;
                            if (bqVar20.Gt() != null) {
                                bqVar23 = this.aCV.aBX;
                                bqVar23.Gt().Hj();
                            }
                            bqVar21 = this.aCV.aBX;
                            if (bqVar21.Gu() != null) {
                                bqVar22 = this.aCV.aBX;
                                bqVar22.Gu().Hj();
                            }
                        } else {
                            bqVar15 = this.aCV.aBX;
                            if (bqVar15.Gt() != null) {
                                bqVar18 = this.aCV.aBX;
                                bqVar18.Gt().Hi();
                            }
                            bqVar16 = this.aCV.aBX;
                            if (bqVar16.Gu() != null) {
                                bqVar17 = this.aCV.aBX;
                                bqVar17.Gu().Hi();
                            }
                        }
                        bqVar19 = this.aCV.aBX;
                        bqVar19.Gf();
                    }
                }
            }
            bqVar14 = this.aCV.aBX;
            bqVar14.setIsManager(false);
            eVar17 = this.aCV.aCh;
            if (eVar17 != null) {
            }
            this.aCV.FD();
            eVar18 = this.aCV.aCh;
            if (!eVar18.aei()) {
            }
            bqVar19 = this.aCV.aBX;
            bqVar19.Gf();
        }
        this.aCV.aBY = null;
        j = this.aCV.aCo;
        if (j > -1) {
            long currentTimeMillis3 = System.currentTimeMillis();
            j2 = this.aCV.aCo;
            eVar6 = this.aCV.aCh;
            long Uc2 = eVar6.Uc();
            j3 = this.aCV.aCo;
            long j8 = Uc2 - j3;
            eVar7 = this.aCV.aCh;
            long Ua2 = eVar7.Ua();
            eVar8 = this.aCV.aCh;
            long Ub2 = eVar8.Ub();
            eVar9 = this.aCV.aCh;
            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - j2, j8, Ua2, Ub2, currentTimeMillis3 - eVar9.TZ());
            this.aCV.aCo = -1L;
        }
        FrsActivity frsActivity8 = this.aCV;
        eVar = this.aCV.aCh;
        frsActivity8.a(eVar);
        eVar2 = this.aCV.aCh;
        this.aCV.g(Boolean.valueOf(eVar2.mP().isIfvoice()));
        eVar3 = this.aCV.aCh;
        if (eVar3 != null) {
            eVar4 = this.aCV.aCh;
            if (eVar4.getUserData() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                eVar5 = this.aCV.aCh;
                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(eVar5.getUserData().getIsMem())));
            }
        }
        this.aCV.agu = System.currentTimeMillis() - currentTimeMillis;
        System.gc();
    }

    @Override // com.baidu.tieba.tbadkCore.x
    public void d(com.baidu.tieba.tbadkCore.e eVar) {
        String str;
        String str2;
        if (eVar != null) {
            str = this.aCV.mPageType;
            if (!str.equals("normal_page")) {
                str2 = this.aCV.mPageType;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.aCV.c(eVar);
        }
    }
}
