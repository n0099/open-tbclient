package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class az implements dd {
    final /* synthetic */ FrsActivity aBu;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dd
    public void eH(int i) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        bu buVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                buVar3 = this.aBu.aAF;
                buVar3.cc(true);
                buVar4 = this.aBu.aAF;
                buVar4.Gr();
                return;
            case 2:
                buVar = this.aBu.aAF;
                buVar.cd(true);
                buVar2 = this.aBu.aAF;
                buVar2.Gr();
                return;
            case 3:
                buVar5 = this.aBu.aAF;
                buVar5.cb(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x044f  */
    @Override // com.baidu.tieba.frs.dd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e eVar) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        bu buVar5;
        bu buVar6;
        boolean z2;
        bu buVar7;
        bu buVar8;
        bu buVar9;
        bu buVar10;
        long j;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        long j2;
        b bVar6;
        long j3;
        b bVar7;
        b bVar8;
        b bVar9;
        bu buVar11;
        b bVar10;
        boolean z3;
        b bVar11;
        String str;
        String str2;
        String str3;
        bu buVar12;
        b bVar12;
        AdapterView.OnItemClickListener onItemClickListener;
        bu buVar13;
        b bVar13;
        b bVar14;
        b bVar15;
        b bVar16;
        bu buVar14;
        b bVar17;
        bu buVar15;
        bu buVar16;
        bu buVar17;
        bu buVar18;
        bu buVar19;
        bu buVar20;
        bu buVar21;
        bu buVar22;
        bu buVar23;
        b bVar18;
        b bVar19;
        bu buVar24;
        b bVar20;
        b bVar21;
        int i2;
        int i3;
        long j4;
        long j5;
        b bVar22;
        long j6;
        b bVar23;
        b bVar24;
        b bVar25;
        int i4;
        bu buVar25;
        b bVar26;
        b bVar27;
        b bVar28;
        b bVar29;
        b bVar30;
        b bVar31;
        b bVar32;
        b bVar33;
        b bVar34;
        boolean z4;
        b bVar35;
        b bVar36;
        bu buVar26;
        b bVar37;
        b bVar38;
        bu buVar27;
        if (eVar != null && eVar.isSuccess) {
            buVar27 = this.aBu.aAF;
            buVar27.GJ().bL(com.baidu.tbadk.core.util.ba.mD().mF());
            FrsActivity.aAJ = 0L;
            FrsActivity.aAK = 0L;
            FrsActivity.aAL = 0;
        } else {
            FrsActivity.aAL = 1;
        }
        buVar = this.aBu.aAF;
        buVar.cb(false);
        switch (i) {
            case 1:
                buVar4 = this.aBu.aAF;
                buVar4.cc(false);
                buVar5 = this.aBu.aAF;
                buVar5.Gr();
                break;
            case 2:
                buVar2 = this.aBu.aAF;
                buVar2.cd(false);
                buVar3 = this.aBu.aAF;
                buVar3.Gr();
                break;
        }
        FrsActivity frsActivity = this.aBu;
        buVar6 = this.aBu.aAF;
        frsActivity.hideLoadingView(buVar6.getRootView());
        if (z || (eVar != null && eVar.errorCode != 0)) {
            z2 = this.aBu.aAt;
            if (!z2) {
                if (eVar != null) {
                    if (eVar.aAl) {
                        FrsActivity frsActivity2 = this.aBu;
                        buVar10 = this.aBu.aAF;
                        frsActivity2.showNetRefreshView(buVar10.getRootView(), this.aBu.getString(com.baidu.tieba.y.net_error_text, new Object[]{eVar.errorMsg, Integer.valueOf(eVar.errorCode)}), true);
                    } else {
                        FrsActivity frsActivity3 = this.aBu;
                        buVar8 = this.aBu.aAF;
                        frsActivity3.showNetRefreshView(buVar8.getRootView(), eVar.errorMsg, true);
                    }
                    buVar9 = this.aBu.aAF;
                    buVar9.eW(8);
                }
            } else if (eVar != null && eVar.aAl) {
                buVar7 = this.aBu.aAF;
                buVar7.eW(0);
                this.aBu.showToast(this.aBu.getString(com.baidu.tieba.y.net_error_text, new Object[]{eVar.errorMsg, Integer.valueOf(eVar.errorCode)}));
            }
        } else {
            buVar11 = this.aBu.aAF;
            buVar11.eW(0);
            bVar10 = this.aBu.azN;
            if (bVar10 != null) {
                bVar34 = this.aBu.azN;
                if (bVar34.Fh().zi() == 1) {
                    this.aBu.mPageType = "frs_page";
                } else {
                    this.aBu.mPageType = "normal_page";
                }
                z4 = this.aBu.aAN;
                if (z4) {
                    this.aBu.mPageType = "good_page";
                }
                FrsActivity frsActivity4 = this.aBu;
                bVar35 = this.aBu.azN;
                frsActivity4.aAx = bVar35.zL().getName();
                FrsActivity frsActivity5 = this.aBu;
                bVar36 = this.aBu.azN;
                frsActivity5.forumId = bVar36.zL().getId();
                buVar26 = this.aBu.aAF;
                bVar37 = this.aBu.azN;
                ForumData zL = bVar37.zL();
                bVar38 = this.aBu.azN;
                buVar26.a(zL, bVar38.getUserData());
            }
            z3 = this.aBu.aAY;
            if (z3) {
                bVar29 = this.aBu.azN;
                if (bVar29 != null) {
                    bVar30 = this.aBu.azN;
                    bVar30.Fk();
                    bVar31 = this.aBu.azN;
                    bVar31.U(this.aBu);
                    bVar32 = this.aBu.azN;
                    bVar32.Fl();
                    FrsActivity frsActivity6 = this.aBu;
                    bVar33 = this.aBu.azN;
                    frsActivity6.e(bVar33);
                }
            }
            bVar11 = this.aBu.azN;
            com.baidu.tbadk.core.data.s top_notice_data = bVar11.zL().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                qVar.setTitle(top_notice_data.getTitle());
                qVar.aT(2);
                qVar.ba(top_notice_data.kO());
                qVar.parser_title();
                bVar28 = this.aBu.azN;
                bVar28.b(qVar);
            }
            str = this.aBu.mPageType;
            if (str.equals("frs_page")) {
                buVar25 = this.aBu.aAF;
                bVar26 = this.aBu.azN;
                int isMem = bVar26.getUserData().getIsMem();
                bVar27 = this.aBu.azN;
                buVar25.L(isMem, bVar27.zL().isLike());
            } else {
                str2 = this.aBu.mPageType;
                if (str2.equals("normal_page")) {
                    buVar13 = this.aBu.aAF;
                    bVar13 = this.aBu.azN;
                    int isMem2 = bVar13.getUserData().getIsMem();
                    bVar14 = this.aBu.azN;
                    buVar13.K(isMem2, bVar14.zL().isLike());
                } else {
                    str3 = this.aBu.mPageType;
                    if (str3.equals("good_page")) {
                        buVar12 = this.aBu.aAF;
                        bVar12 = this.aBu.azN;
                        ArrayList<com.baidu.tbadk.core.data.h> good_classify = bVar12.zL().getGood_classify();
                        onItemClickListener = this.aBu.aBl;
                        buVar12.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.aAJ = (System.nanoTime() - this.startTime) / 1000000;
            if (eVar != null) {
                FrsActivity.aAK = eVar.aAm;
            }
            bVar15 = this.aBu.azN;
            if (bVar15 != null) {
                bVar20 = this.aBu.azN;
                if (bVar20.Fg() != null) {
                    bVar21 = this.aBu.azN;
                    if (bVar21.Fg().size() == 0) {
                        i2 = this.aBu.mType;
                        if (i2 == 1) {
                            this.aBu.showToast(this.aBu.getString(com.baidu.tieba.y.no_more_to_load));
                            i3 = this.aBu.aAz;
                            if (i3 > 1) {
                                FrsActivity frsActivity7 = this.aBu;
                                i4 = frsActivity7.aAz;
                                frsActivity7.aAz = i4 - 1;
                            }
                            j4 = this.aBu.aAU;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.aBu.aAU;
                                bVar22 = this.aBu.azN;
                                long Fe = bVar22.Fe();
                                j6 = this.aBu.aAU;
                                long j7 = Fe - j6;
                                bVar23 = this.aBu.azN;
                                long Fc = bVar23.Fc();
                                bVar24 = this.aBu.azN;
                                long Fd = bVar24.Fd();
                                bVar25 = this.aBu.azN;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis - j5, j7, Fc, Fd, currentTimeMillis - bVar25.Fb());
                                this.aBu.aAU = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            bVar16 = this.aBu.azN;
            if (bVar16 != null) {
                bVar18 = this.aBu.azN;
                if (bVar18.getUserData() != null) {
                    bVar19 = this.aBu.azN;
                    if (bVar19.getUserData().isBawu()) {
                        buVar24 = this.aBu.aAF;
                        buVar24.setIsManager(true);
                        this.aBu.Fy();
                        bVar17 = this.aBu.azN;
                        if (!bVar17.Ff()) {
                            buVar20 = this.aBu.aAF;
                            if (buVar20.Go() != null) {
                                buVar23 = this.aBu.aAF;
                                buVar23.Go().Hb();
                            }
                            buVar21 = this.aBu.aAF;
                            if (buVar21.Gp() != null) {
                                buVar22 = this.aBu.aAF;
                                buVar22.Gp().Hb();
                            }
                        } else {
                            buVar15 = this.aBu.aAF;
                            if (buVar15.Go() != null) {
                                buVar18 = this.aBu.aAF;
                                buVar18.Go().Ha();
                            }
                            buVar16 = this.aBu.aAF;
                            if (buVar16.Gp() != null) {
                                buVar17 = this.aBu.aAF;
                                buVar17.Gp().Ha();
                            }
                        }
                        buVar19 = this.aBu.aAF;
                        buVar19.Ga();
                    }
                }
            }
            buVar14 = this.aBu.aAF;
            buVar14.setIsManager(false);
            this.aBu.Fy();
            bVar17 = this.aBu.azN;
            if (!bVar17.Ff()) {
            }
            buVar19 = this.aBu.aAF;
            buVar19.Ga();
        }
        this.aBu.aAG = null;
        j = this.aBu.aAU;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.aBu.aAU;
            bVar6 = this.aBu.azN;
            long Fe2 = bVar6.Fe();
            j3 = this.aBu.aAU;
            long j8 = Fe2 - j3;
            bVar7 = this.aBu.azN;
            long Fc2 = bVar7.Fc();
            bVar8 = this.aBu.azN;
            long Fd2 = bVar8.Fd();
            bVar9 = this.aBu.azN;
            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j2, j8, Fc2, Fd2, currentTimeMillis2 - bVar9.Fb());
            this.aBu.aAU = -1L;
        }
        FrsActivity frsActivity8 = this.aBu;
        bVar = this.aBu.azN;
        frsActivity8.d(bVar);
        bVar2 = this.aBu.azN;
        this.aBu.f(Boolean.valueOf(bVar2.jZ().isIfvoice()));
        bVar3 = this.aBu.azN;
        if (bVar3 != null) {
            bVar4 = this.aBu.azN;
            if (bVar4.getUserData() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                bVar5 = this.aBu.azN;
                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(bVar5.getUserData().getIsMem())));
            }
        }
        System.gc();
    }

    @Override // com.baidu.tieba.frs.dd
    public void g(b bVar) {
        String str;
        String str2;
        if (bVar != null) {
            str = this.aBu.mPageType;
            if (!str.equals("normal_page")) {
                str2 = this.aBu.mPageType;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.aBu.f(bVar);
        }
    }
}
