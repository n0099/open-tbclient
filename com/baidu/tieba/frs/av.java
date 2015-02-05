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
    final /* synthetic */ FrsActivity aDT;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsActivity frsActivity) {
        this.aDT = frsActivity;
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
                bpVar3 = this.aDT.aCV;
                bpVar3.bQ(true);
                bpVar4 = this.aDT.aCV;
                bpVar4.GN();
                return;
            case 2:
                bpVar = this.aDT.aCV;
                bpVar.bR(true);
                bpVar2 = this.aDT.aCV;
                bpVar2.GN();
                return;
            case 3:
                bpVar5 = this.aDT.aCV;
                bpVar5.bP(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x055b  */
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
        bp bpVar7;
        boolean z2;
        bp bpVar8;
        bp bpVar9;
        bp bpVar10;
        bp bpVar11;
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
        bp bpVar12;
        com.baidu.tieba.tbadkCore.e eVar10;
        boolean z3;
        com.baidu.tieba.tbadkCore.e eVar11;
        String str;
        String str2;
        String str3;
        bp bpVar13;
        com.baidu.tieba.tbadkCore.e eVar12;
        AdapterView.OnItemClickListener onItemClickListener;
        bp bpVar14;
        com.baidu.tieba.tbadkCore.e eVar13;
        com.baidu.tieba.tbadkCore.e eVar14;
        com.baidu.tieba.tbadkCore.e eVar15;
        com.baidu.tieba.tbadkCore.e eVar16;
        bp bpVar15;
        com.baidu.tieba.tbadkCore.e eVar17;
        com.baidu.tieba.tbadkCore.e eVar18;
        bp bpVar16;
        bp bpVar17;
        bp bpVar18;
        bp bpVar19;
        bp bpVar20;
        bp bpVar21;
        bp bpVar22;
        bp bpVar23;
        bp bpVar24;
        com.baidu.tieba.tbadkCore.e eVar19;
        bp bpVar25;
        com.baidu.tieba.tbadkCore.e eVar20;
        com.baidu.tieba.tbadkCore.e eVar21;
        com.baidu.tieba.tbadkCore.e eVar22;
        bp bpVar26;
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
        bp bpVar27;
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
        bp bpVar28;
        com.baidu.tieba.tbadkCore.e eVar40;
        com.baidu.tieba.tbadkCore.e eVar41;
        bp bpVar29;
        if (hVar != null && hVar.isSuccess) {
            bpVar29 = this.aDT.aCV;
            bpVar29.Hf().bD(com.baidu.tbadk.core.util.bg.pB().pD());
            FrsActivity.aCZ = 0L;
            FrsActivity.aDa = 0L;
            FrsActivity.aDb = 0;
        } else {
            FrsActivity.aDb = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bpVar = this.aDT.aCV;
        bpVar.bP(false);
        switch (i) {
            case 1:
                bpVar4 = this.aDT.aCV;
                bpVar4.bQ(false);
                bpVar5 = this.aDT.aCV;
                bpVar5.GN();
                break;
            case 2:
                bpVar2 = this.aDT.aCV;
                bpVar2.bR(false);
                bpVar3 = this.aDT.aCV;
                bpVar3.GN();
                break;
        }
        FrsActivity frsActivity = this.aDT;
        bpVar6 = this.aDT.aCV;
        frsActivity.hideLoadingView(bpVar6.getRootView());
        FrsActivity frsActivity2 = this.aDT;
        bpVar7 = this.aDT.aCV;
        frsActivity2.hideNetRefreshView(bpVar7.getRootView());
        if (z || (hVar != null && hVar.errorCode != 0)) {
            z2 = this.aDT.aCJ;
            if (!z2) {
                if (hVar != null) {
                    if (hVar.bTX) {
                        FrsActivity frsActivity3 = this.aDT;
                        bpVar11 = this.aDT.aCV;
                        frsActivity3.showNetRefreshView(bpVar11.getRootView(), this.aDT.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), true);
                    } else {
                        FrsActivity frsActivity4 = this.aDT;
                        bpVar9 = this.aDT.aCV;
                        frsActivity4.showNetRefreshView(bpVar9.getRootView(), hVar.errorMsg, true);
                    }
                    bpVar10 = this.aDT.aCV;
                    bpVar10.fa(8);
                }
            } else if (hVar != null && hVar.bTX) {
                bpVar8 = this.aDT.aCV;
                bpVar8.fa(0);
                this.aDT.showToast(this.aDT.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)));
            }
        } else {
            this.aDT.aCJ = true;
            bpVar12 = this.aDT.aCV;
            bpVar12.fa(0);
            eVar10 = this.aDT.aDf;
            if (eVar10 != null) {
                eVar37 = this.aDT.aDf;
                if (eVar37.aeK().aeP() == 1) {
                    this.aDT.mPageType = "frs_page";
                } else {
                    this.aDT.mPageType = "normal_page";
                }
                z4 = this.aDT.aDd;
                if (z4) {
                    this.aDT.mPageType = "good_page";
                }
                FrsActivity frsActivity5 = this.aDT;
                eVar38 = this.aDT.aDf;
                frsActivity5.aCN = eVar38.aeI().getName();
                FrsActivity frsActivity6 = this.aDT;
                eVar39 = this.aDT.aDf;
                frsActivity6.forumId = eVar39.aeI().getId();
                bpVar28 = this.aDT.aCV;
                eVar40 = this.aDT.aDf;
                ForumData aeI = eVar40.aeI();
                eVar41 = this.aDT.aDf;
                bpVar28.a(aeI, eVar41.getUserData());
            }
            z3 = this.aDT.aDr;
            if (z3) {
                eVar32 = this.aDT.aDf;
                if (eVar32 != null) {
                    eVar33 = this.aDT.aDf;
                    eVar33.aeN();
                    if (TbadkCoreApplication.m255getInst().isRecAppExist()) {
                        eVar36 = this.aDT.aDf;
                        eVar36.av(this.aDT.getPageContext().getPageActivity());
                    }
                    eVar34 = this.aDT.aDf;
                    eVar34.aeO();
                    FrsActivity frsActivity7 = this.aDT;
                    eVar35 = this.aDT.aDf;
                    frsActivity7.b(eVar35);
                }
            }
            eVar11 = this.aDT.aDf;
            com.baidu.tbadk.core.data.z top_notice_data = eVar11.aeI().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.setTitle(top_notice_data.getTitle());
                xVar.bu(2);
                xVar.bN(top_notice_data.nK());
                xVar.parser_title();
                eVar31 = this.aDT.aDf;
                eVar31.d(xVar);
            }
            str = this.aDT.mPageType;
            if (str.equals("frs_page")) {
                bpVar27 = this.aDT.aCV;
                eVar29 = this.aDT.aDf;
                int isMem = eVar29.getUserData().getIsMem();
                eVar30 = this.aDT.aDf;
                bpVar27.O(isMem, eVar30.aeI().isLike());
            } else {
                str2 = this.aDT.mPageType;
                if (str2.equals("normal_page")) {
                    bpVar14 = this.aDT.aCV;
                    eVar13 = this.aDT.aDf;
                    int isMem2 = eVar13.getUserData().getIsMem();
                    eVar14 = this.aDT.aDf;
                    bpVar14.N(isMem2, eVar14.aeI().isLike());
                } else {
                    str3 = this.aDT.mPageType;
                    if (str3.equals("good_page")) {
                        bpVar13 = this.aDT.aCV;
                        eVar12 = this.aDT.aDf;
                        ArrayList<com.baidu.tbadk.core.data.k> good_classify = eVar12.aeI().getGood_classify();
                        onItemClickListener = this.aDT.aDK;
                        bpVar13.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.aCZ = (System.nanoTime() - this.startTime) / 1000000;
            if (hVar != null) {
                FrsActivity.aDa = hVar.bTY;
            }
            eVar15 = this.aDT.aDf;
            if (eVar15 != null) {
                eVar23 = this.aDT.aDf;
                if (eVar23.aeJ() != null) {
                    eVar24 = this.aDT.aDf;
                    if (eVar24.aeJ().size() == 0) {
                        i2 = this.aDT.mType;
                        if (i2 == 1) {
                            this.aDT.showToast(this.aDT.getPageContext().getString(com.baidu.tieba.z.no_more_to_load));
                            i3 = this.aDT.aCP;
                            if (i3 > 1) {
                                FrsActivity frsActivity8 = this.aDT;
                                i4 = frsActivity8.aCP;
                                frsActivity8.aCP = i4 - 1;
                            }
                            j4 = this.aDT.aDm;
                            if (j4 > -1) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                j5 = this.aDT.aDm;
                                eVar25 = this.aDT.aDf;
                                long Uv = eVar25.Uv();
                                j6 = this.aDT.aDm;
                                long j7 = Uv - j6;
                                eVar26 = this.aDT.aDf;
                                long Ut = eVar26.Ut();
                                eVar27 = this.aDT.aDf;
                                long Uu = eVar27.Uu();
                                eVar28 = this.aDT.aDf;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j5, j7, Ut, Uu, currentTimeMillis2 - eVar28.Us());
                                this.aDT.aDm = -1L;
                            }
                            this.aDT.agP = System.currentTimeMillis() - currentTimeMillis;
                            return;
                        }
                    }
                }
            }
            eVar16 = this.aDT.aDf;
            if (eVar16 != null) {
                eVar21 = this.aDT.aDf;
                if (eVar21.getUserData() != null) {
                    eVar22 = this.aDT.aDf;
                    if (eVar22.getUserData().isBawu()) {
                        bpVar26 = this.aDT.aCV;
                        bpVar26.setIsManager(true);
                        eVar17 = this.aDT.aDf;
                        if (eVar17 != null) {
                            eVar19 = this.aDT.aDf;
                            if (eVar19.aeI() != null) {
                                bpVar25 = this.aDT.aCV;
                                eVar20 = this.aDT.aDf;
                                bpVar25.bU(eVar20.aeI().isLike() == 1);
                            }
                        }
                        this.aDT.FV();
                        eVar18 = this.aDT.aDf;
                        if (!eVar18.aeH()) {
                            bpVar21 = this.aDT.aCV;
                            if (bpVar21.GK() != null) {
                                bpVar24 = this.aDT.aCV;
                                bpVar24.GK().HB();
                            }
                            bpVar22 = this.aDT.aCV;
                            if (bpVar22.GL() != null) {
                                bpVar23 = this.aDT.aCV;
                                bpVar23.GL().HB();
                            }
                        } else {
                            bpVar16 = this.aDT.aCV;
                            if (bpVar16.GK() != null) {
                                bpVar19 = this.aDT.aCV;
                                bpVar19.GK().HA();
                            }
                            bpVar17 = this.aDT.aCV;
                            if (bpVar17.GL() != null) {
                                bpVar18 = this.aDT.aCV;
                                bpVar18.GL().HA();
                            }
                        }
                        bpVar20 = this.aDT.aCV;
                        bpVar20.Gw();
                    }
                }
            }
            bpVar15 = this.aDT.aCV;
            bpVar15.setIsManager(false);
            eVar17 = this.aDT.aDf;
            if (eVar17 != null) {
            }
            this.aDT.FV();
            eVar18 = this.aDT.aDf;
            if (!eVar18.aeH()) {
            }
            bpVar20 = this.aDT.aCV;
            bpVar20.Gw();
        }
        this.aDT.aCW = null;
        j = this.aDT.aDm;
        if (j > -1) {
            long currentTimeMillis3 = System.currentTimeMillis();
            j2 = this.aDT.aDm;
            eVar6 = this.aDT.aDf;
            long Uv2 = eVar6.Uv();
            j3 = this.aDT.aDm;
            long j8 = Uv2 - j3;
            eVar7 = this.aDT.aDf;
            long Ut2 = eVar7.Ut();
            eVar8 = this.aDT.aDf;
            long Uu2 = eVar8.Uu();
            eVar9 = this.aDT.aDf;
            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - j2, j8, Ut2, Uu2, currentTimeMillis3 - eVar9.Us());
            this.aDT.aDm = -1L;
        }
        FrsActivity frsActivity9 = this.aDT;
        eVar = this.aDT.aDf;
        frsActivity9.a(eVar);
        eVar2 = this.aDT.aDf;
        this.aDT.g(Boolean.valueOf(eVar2.mK().isIfvoice()));
        eVar3 = this.aDT.aDf;
        if (eVar3 != null) {
            eVar4 = this.aDT.aDf;
            if (eVar4.getUserData() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                eVar5 = this.aDT.aDf;
                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(eVar5.getUserData().getIsMem())));
            }
        }
        this.aDT.agP = System.currentTimeMillis() - currentTimeMillis;
        System.gc();
    }

    @Override // com.baidu.tieba.tbadkCore.x
    public void d(com.baidu.tieba.tbadkCore.e eVar) {
        String str;
        String str2;
        if (eVar != null) {
            str = this.aDT.mPageType;
            if (!str.equals("normal_page")) {
                str2 = this.aDT.mPageType;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.aDT.c(eVar);
        }
    }
}
