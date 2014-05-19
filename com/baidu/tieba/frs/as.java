package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
class as implements dg {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(int i) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        cs csVar4;
        cs csVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                csVar3 = this.a.w;
                csVar3.c(true);
                csVar4 = this.a.w;
                csVar4.z();
                return;
            case 2:
                csVar = this.a.w;
                csVar.d(true);
                csVar2 = this.a.w;
                csVar2.z();
                return;
            case 3:
                csVar5 = this.a.w;
                csVar5.b(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x046d  */
    @Override // com.baidu.tieba.frs.dg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, j jVar) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        cs csVar4;
        cs csVar5;
        cs csVar6;
        long j;
        g gVar;
        g gVar2;
        long j2;
        g gVar3;
        long j3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        boolean z2;
        g gVar8;
        g gVar9;
        boolean z3;
        String str;
        String str2;
        String str3;
        cs csVar7;
        g gVar10;
        AdapterView.OnItemClickListener onItemClickListener;
        cs csVar8;
        g gVar11;
        g gVar12;
        cs csVar9;
        g gVar13;
        cs csVar10;
        cs csVar11;
        cs csVar12;
        cs csVar13;
        g gVar14;
        g gVar15;
        cs csVar14;
        g gVar16;
        g gVar17;
        int i2;
        int i3;
        long j4;
        long j5;
        g gVar18;
        long j6;
        g gVar19;
        g gVar20;
        g gVar21;
        int i4;
        cs csVar15;
        cs csVar16;
        g gVar22;
        String str4;
        g gVar23;
        String str5;
        g gVar24;
        g gVar25;
        g gVar26;
        String str6;
        String str7;
        String str8;
        g gVar27;
        g gVar28;
        boolean z4;
        cs csVar17;
        cs csVar18;
        cs csVar19;
        cs csVar20;
        g gVar29;
        cs csVar21;
        cs csVar22;
        cs csVar23;
        cs csVar24;
        cs csVar25;
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            csVar25 = this.a.w;
            csVar25.p();
        } else {
            csVar = this.a.w;
            csVar.q();
        }
        if (jVar != null && jVar.b) {
            csVar24 = this.a.w;
            csVar24.v().a(com.baidu.tbadk.core.util.bf.a().b());
            FrsActivity.A = 0L;
            FrsActivity.B = 0L;
            FrsActivity.C = 0;
        } else {
            FrsActivity.C = 1;
        }
        csVar2 = this.a.w;
        csVar2.b(false);
        switch (i) {
            case 1:
                csVar5 = this.a.w;
                csVar5.c(false);
                csVar6 = this.a.w;
                csVar6.z();
                break;
            case 2:
                csVar3 = this.a.w;
                csVar3.d(false);
                csVar4 = this.a.w;
                csVar4.z();
                break;
        }
        if (!z && (jVar == null || jVar.c == 0)) {
            gVar7 = this.a.I;
            if (gVar7 != null) {
                gVar27 = this.a.I;
                if (gVar27.l().a() == 1) {
                    this.a.O = "frs_page";
                } else {
                    this.a.O = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                gVar28 = this.a.I;
                frsActivity.n = gVar28.g().getName();
                z4 = this.a.E;
                if (!z4) {
                    csVar17 = this.a.w;
                    csVar17.ac().setVisibility(0);
                    csVar18 = this.a.w;
                    csVar18.ad().setVisibility(4);
                    csVar19 = this.a.w;
                    csVar19.ae().setVisibility(4);
                } else {
                    this.a.O = "good_page";
                    csVar21 = this.a.w;
                    csVar21.ac().setVisibility(4);
                    csVar22 = this.a.w;
                    csVar22.ad().setVisibility(0);
                    csVar23 = this.a.w;
                    csVar23.ae().setVisibility(4);
                }
                csVar20 = this.a.w;
                gVar29 = this.a.I;
                csVar20.a(gVar29.g());
            }
            z2 = this.a.G;
            if (z2) {
                LimitList hasShowAppForums = TbadkApplication.m252getInst().getHasShowAppForums();
                str4 = this.a.n;
                if (!hasShowAppForums.contains(str4)) {
                    FrsActivity frsActivity2 = this.a;
                    gVar23 = this.a.I;
                    frsActivity2.c(gVar23);
                    this.a.G = false;
                    LimitList hasShowAppForums2 = TbadkApplication.m252getInst().getHasShowAppForums();
                    str5 = this.a.n;
                    hasShowAppForums2.add(str5);
                    gVar24 = this.a.I;
                    if (gVar24 != null) {
                        gVar25 = this.a.I;
                        if (gVar25.g() != null) {
                            gVar26 = this.a.I;
                            com.baidu.tbadk.core.data.c bannerListData = gVar26.g().getBannerListData();
                            if (bannerListData != null && bannerListData.a() != null) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 < bannerListData.a().size()) {
                                        FrsActivity frsActivity3 = this.a;
                                        str7 = frsActivity3.X;
                                        frsActivity3.X = String.valueOf(str7) + bannerListData.a().get(i6).e();
                                        if (i6 < bannerListData.a().size() - 1) {
                                            FrsActivity frsActivity4 = this.a;
                                            str8 = frsActivity4.X;
                                            frsActivity4.X = String.valueOf(str8) + "|";
                                        }
                                        i5 = i6 + 1;
                                    } else {
                                        FrsActivity frsActivity5 = this.a;
                                        str6 = this.a.X;
                                        TiebaStatic.eventStat(frsActivity5, "frs_show_app", "frs_recommend_app", 1, "app_name", str6);
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            FrsActivity frsActivity6 = this.a;
            gVar8 = this.a.I;
            frsActivity6.b(gVar8);
            gVar9 = this.a.I;
            com.baidu.tbadk.core.data.p top_notice_data = gVar9.g().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                oVar.c(top_notice_data.a());
                oVar.c(2);
                oVar.b(top_notice_data.b());
                oVar.G();
                gVar22 = this.a.I;
                gVar22.a(oVar);
            }
            z3 = this.a.F;
            if (z3) {
                csVar16 = this.a.w;
                csVar16.J();
                this.a.F = false;
            }
            str = this.a.O;
            if (str.equals("frs_page")) {
                csVar15 = this.a.w;
                csVar15.B();
            } else {
                str2 = this.a.O;
                if (str2.equals("normal_page")) {
                    csVar8 = this.a.w;
                    csVar8.A();
                } else {
                    str3 = this.a.O;
                    if (str3.equals("good_page")) {
                        csVar7 = this.a.w;
                        gVar10 = this.a.I;
                        ArrayList<com.baidu.tbadk.core.data.g> good_classify = gVar10.g().getGood_classify();
                        onItemClickListener = this.a.ax;
                        csVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.A = (System.nanoTime() - this.b) / 1000000;
            if (jVar != null) {
                FrsActivity.B = jVar.e;
            }
            gVar11 = this.a.I;
            if (gVar11 != null) {
                gVar16 = this.a.I;
                if (gVar16.h() != null) {
                    gVar17 = this.a.I;
                    if (gVar17.h().size() == 0) {
                        i2 = this.a.m;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(com.baidu.tieba.u.no_more_to_load));
                            i3 = this.a.q;
                            if (i3 > 1) {
                                FrsActivity frsActivity7 = this.a;
                                i4 = frsActivity7.q;
                                frsActivity7.q = i4 - 1;
                            }
                            j4 = this.a.V;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.a.V;
                                gVar18 = this.a.I;
                                long e = gVar18.e();
                                j6 = this.a.V;
                                long j7 = e - j6;
                                gVar19 = this.a.I;
                                long c = gVar19.c();
                                gVar20 = this.a.I;
                                long d = gVar20.d();
                                gVar21 = this.a.I;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis - j5, j7, c, d, currentTimeMillis - gVar21.b());
                                this.a.V = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            gVar12 = this.a.I;
            if (gVar12 != null) {
                gVar14 = this.a.I;
                if (gVar14.i() != null) {
                    gVar15 = this.a.I;
                    if (gVar15.i().getIsManager()) {
                        csVar14 = this.a.w;
                        csVar14.f(true);
                        this.a.G();
                        gVar13 = this.a.I;
                        if (!gVar13.f()) {
                            csVar12 = this.a.w;
                            csVar12.w().h();
                            csVar13 = this.a.w;
                            csVar13.x().g();
                        } else {
                            csVar10 = this.a.w;
                            csVar10.w().g();
                            csVar11 = this.a.w;
                            csVar11.x().f();
                        }
                    }
                }
            }
            csVar9 = this.a.w;
            csVar9.f(false);
            this.a.G();
            gVar13 = this.a.I;
            if (!gVar13.f()) {
            }
        } else {
            this.a.a(jVar);
        }
        this.a.x = null;
        j = this.a.V;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.V;
            gVar3 = this.a.I;
            long e2 = gVar3.e();
            j3 = this.a.V;
            long j8 = e2 - j3;
            gVar4 = this.a.I;
            long c2 = gVar4.c();
            gVar5 = this.a.I;
            long d2 = gVar5.d();
            gVar6 = this.a.I;
            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j2, j8, c2, d2, currentTimeMillis2 - gVar6.b());
            this.a.V = -1L;
        }
        FrsActivity frsActivity8 = this.a;
        gVar = this.a.I;
        frsActivity8.a(gVar);
        gVar2 = this.a.I;
        this.a.a(Boolean.valueOf(gVar2.j().isIfvoice()));
        System.gc();
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(g gVar) {
        String str;
        String str2;
        if (gVar != null) {
            str = this.a.O;
            if (!str.equals("normal_page")) {
                str2 = this.a.O;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.a.d(gVar);
        }
    }
}
