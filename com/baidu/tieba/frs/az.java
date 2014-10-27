package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class az implements dd {
    final /* synthetic */ FrsActivity aBk;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FrsActivity frsActivity) {
        this.aBk = frsActivity;
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
                buVar3 = this.aBk.aAv;
                buVar3.cc(true);
                buVar4 = this.aBk.aAv;
                buVar4.Gp();
                return;
            case 2:
                buVar = this.aBk.aAv;
                buVar.cd(true);
                buVar2 = this.aBk.aAv;
                buVar2.Gp();
                return;
            case 3:
                buVar5 = this.aBk.aAv;
                buVar5.cb(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0436  */
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
            buVar27 = this.aBk.aAv;
            buVar27.GH().bL(com.baidu.tbadk.core.util.az.mD().mF());
            FrsActivity.aAz = 0L;
            FrsActivity.aAA = 0L;
            FrsActivity.aAB = 0;
        } else {
            FrsActivity.aAB = 1;
        }
        buVar = this.aBk.aAv;
        buVar.cb(false);
        switch (i) {
            case 1:
                buVar4 = this.aBk.aAv;
                buVar4.cc(false);
                buVar5 = this.aBk.aAv;
                buVar5.Gp();
                break;
            case 2:
                buVar2 = this.aBk.aAv;
                buVar2.cd(false);
                buVar3 = this.aBk.aAv;
                buVar3.Gp();
                break;
        }
        FrsActivity frsActivity = this.aBk;
        buVar6 = this.aBk.aAv;
        frsActivity.hideLoadingView(buVar6.getRootView());
        if (z || (eVar != null && eVar.errorCode != 0)) {
            z2 = this.aBk.aAj;
            if (!z2) {
                if (eVar != null) {
                    if (eVar.aAc) {
                        FrsActivity frsActivity2 = this.aBk;
                        buVar10 = this.aBk.aAv;
                        frsActivity2.showNetRefreshView(buVar10.getRootView(), this.aBk.getString(com.baidu.tieba.y.net_error_text, new Object[]{eVar.errorMsg, Integer.valueOf(eVar.errorCode)}), true);
                    } else {
                        FrsActivity frsActivity3 = this.aBk;
                        buVar8 = this.aBk.aAv;
                        frsActivity3.showNetRefreshView(buVar8.getRootView(), eVar.errorMsg, true);
                    }
                    buVar9 = this.aBk.aAv;
                    buVar9.eW(8);
                }
            } else if (eVar != null && eVar.aAc) {
                buVar7 = this.aBk.aAv;
                buVar7.eW(0);
                this.aBk.showToast(eVar.errorMsg);
            }
        } else {
            buVar11 = this.aBk.aAv;
            buVar11.eW(0);
            bVar10 = this.aBk.azE;
            if (bVar10 != null) {
                bVar34 = this.aBk.azE;
                if (bVar34.Ff().zg() == 1) {
                    this.aBk.mPageType = "frs_page";
                } else {
                    this.aBk.mPageType = "normal_page";
                }
                z4 = this.aBk.aAD;
                if (z4) {
                    this.aBk.mPageType = "good_page";
                }
                FrsActivity frsActivity4 = this.aBk;
                bVar35 = this.aBk.azE;
                frsActivity4.aAn = bVar35.zJ().getName();
                FrsActivity frsActivity5 = this.aBk;
                bVar36 = this.aBk.azE;
                frsActivity5.forumId = bVar36.zJ().getId();
                buVar26 = this.aBk.aAv;
                bVar37 = this.aBk.azE;
                ForumData zJ = bVar37.zJ();
                bVar38 = this.aBk.azE;
                buVar26.a(zJ, bVar38.getUserData());
            }
            z3 = this.aBk.aAO;
            if (z3) {
                bVar29 = this.aBk.azE;
                if (bVar29 != null) {
                    bVar30 = this.aBk.azE;
                    bVar30.Fi();
                    bVar31 = this.aBk.azE;
                    bVar31.U(this.aBk);
                    bVar32 = this.aBk.azE;
                    bVar32.Fj();
                    FrsActivity frsActivity6 = this.aBk;
                    bVar33 = this.aBk.azE;
                    frsActivity6.e(bVar33);
                }
            }
            bVar11 = this.aBk.azE;
            com.baidu.tbadk.core.data.s top_notice_data = bVar11.zJ().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                qVar.setTitle(top_notice_data.getTitle());
                qVar.aT(2);
                qVar.ba(top_notice_data.kO());
                qVar.parser_title();
                bVar28 = this.aBk.azE;
                bVar28.b(qVar);
            }
            str = this.aBk.mPageType;
            if (str.equals("frs_page")) {
                buVar25 = this.aBk.aAv;
                bVar26 = this.aBk.azE;
                int isMem = bVar26.getUserData().getIsMem();
                bVar27 = this.aBk.azE;
                buVar25.L(isMem, bVar27.zJ().isLike());
            } else {
                str2 = this.aBk.mPageType;
                if (str2.equals("normal_page")) {
                    buVar13 = this.aBk.aAv;
                    bVar13 = this.aBk.azE;
                    int isMem2 = bVar13.getUserData().getIsMem();
                    bVar14 = this.aBk.azE;
                    buVar13.K(isMem2, bVar14.zJ().isLike());
                } else {
                    str3 = this.aBk.mPageType;
                    if (str3.equals("good_page")) {
                        buVar12 = this.aBk.aAv;
                        bVar12 = this.aBk.azE;
                        ArrayList<com.baidu.tbadk.core.data.h> good_classify = bVar12.zJ().getGood_classify();
                        onItemClickListener = this.aBk.aBb;
                        buVar12.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.aAz = (System.nanoTime() - this.startTime) / 1000000;
            if (eVar != null) {
                FrsActivity.aAA = eVar.aAd;
            }
            bVar15 = this.aBk.azE;
            if (bVar15 != null) {
                bVar20 = this.aBk.azE;
                if (bVar20.Fe() != null) {
                    bVar21 = this.aBk.azE;
                    if (bVar21.Fe().size() == 0) {
                        i2 = this.aBk.mType;
                        if (i2 == 1) {
                            this.aBk.showToast(this.aBk.getString(com.baidu.tieba.y.no_more_to_load));
                            i3 = this.aBk.aAp;
                            if (i3 > 1) {
                                FrsActivity frsActivity7 = this.aBk;
                                i4 = frsActivity7.aAp;
                                frsActivity7.aAp = i4 - 1;
                            }
                            j4 = this.aBk.aAK;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.aBk.aAK;
                                bVar22 = this.aBk.azE;
                                long Fc = bVar22.Fc();
                                j6 = this.aBk.aAK;
                                long j7 = Fc - j6;
                                bVar23 = this.aBk.azE;
                                long Fa = bVar23.Fa();
                                bVar24 = this.aBk.azE;
                                long Fb = bVar24.Fb();
                                bVar25 = this.aBk.azE;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis - j5, j7, Fa, Fb, currentTimeMillis - bVar25.EZ());
                                this.aBk.aAK = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            bVar16 = this.aBk.azE;
            if (bVar16 != null) {
                bVar18 = this.aBk.azE;
                if (bVar18.getUserData() != null) {
                    bVar19 = this.aBk.azE;
                    if (bVar19.getUserData().isBawu()) {
                        buVar24 = this.aBk.aAv;
                        buVar24.setIsManager(true);
                        this.aBk.Fw();
                        bVar17 = this.aBk.azE;
                        if (!bVar17.Fd()) {
                            buVar20 = this.aBk.aAv;
                            if (buVar20.Gm() != null) {
                                buVar23 = this.aBk.aAv;
                                buVar23.Gm().GZ();
                            }
                            buVar21 = this.aBk.aAv;
                            if (buVar21.Gn() != null) {
                                buVar22 = this.aBk.aAv;
                                buVar22.Gn().GZ();
                            }
                        } else {
                            buVar15 = this.aBk.aAv;
                            if (buVar15.Gm() != null) {
                                buVar18 = this.aBk.aAv;
                                buVar18.Gm().GY();
                            }
                            buVar16 = this.aBk.aAv;
                            if (buVar16.Gn() != null) {
                                buVar17 = this.aBk.aAv;
                                buVar17.Gn().GY();
                            }
                        }
                        buVar19 = this.aBk.aAv;
                        buVar19.FY();
                    }
                }
            }
            buVar14 = this.aBk.aAv;
            buVar14.setIsManager(false);
            this.aBk.Fw();
            bVar17 = this.aBk.azE;
            if (!bVar17.Fd()) {
            }
            buVar19 = this.aBk.aAv;
            buVar19.FY();
        }
        this.aBk.aAw = null;
        j = this.aBk.aAK;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.aBk.aAK;
            bVar6 = this.aBk.azE;
            long Fc2 = bVar6.Fc();
            j3 = this.aBk.aAK;
            long j8 = Fc2 - j3;
            bVar7 = this.aBk.azE;
            long Fa2 = bVar7.Fa();
            bVar8 = this.aBk.azE;
            long Fb2 = bVar8.Fb();
            bVar9 = this.aBk.azE;
            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j2, j8, Fa2, Fb2, currentTimeMillis2 - bVar9.EZ());
            this.aBk.aAK = -1L;
        }
        FrsActivity frsActivity8 = this.aBk;
        bVar = this.aBk.azE;
        frsActivity8.d(bVar);
        bVar2 = this.aBk.azE;
        this.aBk.f(Boolean.valueOf(bVar2.jZ().isIfvoice()));
        bVar3 = this.aBk.azE;
        if (bVar3 != null) {
            bVar4 = this.aBk.azE;
            if (bVar4.getUserData() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                bVar5 = this.aBk.azE;
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
            str = this.aBk.mPageType;
            if (!str.equals("normal_page")) {
                str2 = this.aBk.mPageType;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.aBk.f(bVar);
        }
    }
}
