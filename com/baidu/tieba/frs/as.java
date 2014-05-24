package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
class as implements dh {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        ct ctVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                ctVar3 = this.a.w;
                ctVar3.c(true);
                ctVar4 = this.a.w;
                ctVar4.z();
                return;
            case 2:
                ctVar = this.a.w;
                ctVar.d(true);
                ctVar2 = this.a.w;
                ctVar2.z();
                return;
            case 3:
                ctVar5 = this.a.w;
                ctVar5.b(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x046d  */
    @Override // com.baidu.tieba.frs.dh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, j jVar) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        ct ctVar5;
        ct ctVar6;
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
        g gVar8;
        boolean z2;
        g gVar9;
        g gVar10;
        boolean z3;
        String str;
        String str2;
        String str3;
        ct ctVar7;
        g gVar11;
        AdapterView.OnItemClickListener onItemClickListener;
        ct ctVar8;
        g gVar12;
        g gVar13;
        ct ctVar9;
        g gVar14;
        ct ctVar10;
        ct ctVar11;
        ct ctVar12;
        ct ctVar13;
        g gVar15;
        g gVar16;
        ct ctVar14;
        g gVar17;
        g gVar18;
        int i2;
        int i3;
        long j4;
        long j5;
        g gVar19;
        long j6;
        g gVar20;
        g gVar21;
        g gVar22;
        int i4;
        ct ctVar15;
        ct ctVar16;
        g gVar23;
        String str4;
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
        ct ctVar17;
        ct ctVar18;
        ct ctVar19;
        ct ctVar20;
        g gVar29;
        ct ctVar21;
        ct ctVar22;
        ct ctVar23;
        ct ctVar24;
        ct ctVar25;
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            ctVar25 = this.a.w;
            ctVar25.p();
        } else {
            ctVar = this.a.w;
            ctVar.q();
        }
        if (jVar != null && jVar.b) {
            ctVar24 = this.a.w;
            ctVar24.v().a(com.baidu.tbadk.core.util.bf.a().b());
            FrsActivity.A = 0L;
            FrsActivity.B = 0L;
            FrsActivity.C = 0;
        } else {
            FrsActivity.C = 1;
        }
        ctVar2 = this.a.w;
        ctVar2.b(false);
        switch (i) {
            case 1:
                ctVar5 = this.a.w;
                ctVar5.c(false);
                ctVar6 = this.a.w;
                ctVar6.z();
                break;
            case 2:
                ctVar3 = this.a.w;
                ctVar3.d(false);
                ctVar4 = this.a.w;
                ctVar4.z();
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
                    ctVar17 = this.a.w;
                    ctVar17.ac().setVisibility(0);
                    ctVar18 = this.a.w;
                    ctVar18.ad().setVisibility(4);
                    ctVar19 = this.a.w;
                    ctVar19.ae().setVisibility(4);
                } else {
                    this.a.O = "good_page";
                    ctVar21 = this.a.w;
                    ctVar21.ac().setVisibility(4);
                    ctVar22 = this.a.w;
                    ctVar22.ad().setVisibility(0);
                    ctVar23 = this.a.w;
                    ctVar23.ae().setVisibility(4);
                }
                ctVar20 = this.a.w;
                gVar29 = this.a.I;
                ctVar20.a(gVar29.g());
            }
            FrsActivity frsActivity2 = this.a;
            gVar8 = this.a.I;
            frsActivity2.c(gVar8);
            z2 = this.a.G;
            if (z2) {
                LimitList hasShowAppForums = TbadkApplication.m252getInst().getHasShowAppForums();
                str4 = this.a.n;
                if (!hasShowAppForums.contains(str4)) {
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
                                        str7 = frsActivity3.W;
                                        frsActivity3.W = String.valueOf(str7) + bannerListData.a().get(i6).i();
                                        if (i6 < bannerListData.a().size() - 1) {
                                            FrsActivity frsActivity4 = this.a;
                                            str8 = frsActivity4.W;
                                            frsActivity4.W = String.valueOf(str8) + "|";
                                        }
                                        i5 = i6 + 1;
                                    } else {
                                        FrsActivity frsActivity5 = this.a;
                                        str6 = this.a.W;
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
            gVar9 = this.a.I;
            frsActivity6.b(gVar9);
            gVar10 = this.a.I;
            com.baidu.tbadk.core.data.o top_notice_data = gVar10.g().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                nVar.c(top_notice_data.a());
                nVar.c(2);
                nVar.b(top_notice_data.b());
                nVar.L();
                gVar23 = this.a.I;
                gVar23.a(nVar);
            }
            z3 = this.a.F;
            if (z3) {
                ctVar16 = this.a.w;
                ctVar16.J();
                this.a.F = false;
            }
            str = this.a.O;
            if (str.equals("frs_page")) {
                ctVar15 = this.a.w;
                ctVar15.B();
            } else {
                str2 = this.a.O;
                if (str2.equals("normal_page")) {
                    ctVar8 = this.a.w;
                    ctVar8.A();
                } else {
                    str3 = this.a.O;
                    if (str3.equals("good_page")) {
                        ctVar7 = this.a.w;
                        gVar11 = this.a.I;
                        ArrayList<com.baidu.tbadk.core.data.g> good_classify = gVar11.g().getGood_classify();
                        onItemClickListener = this.a.au;
                        ctVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.A = (System.nanoTime() - this.b) / 1000000;
            if (jVar != null) {
                FrsActivity.B = jVar.e;
            }
            gVar12 = this.a.I;
            if (gVar12 != null) {
                gVar17 = this.a.I;
                if (gVar17.h() != null) {
                    gVar18 = this.a.I;
                    if (gVar18.h().size() == 0) {
                        i2 = this.a.m;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(com.baidu.tieba.y.no_more_to_load));
                            i3 = this.a.q;
                            if (i3 > 1) {
                                FrsActivity frsActivity7 = this.a;
                                i4 = frsActivity7.q;
                                frsActivity7.q = i4 - 1;
                            }
                            j4 = this.a.U;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.a.U;
                                gVar19 = this.a.I;
                                long e = gVar19.e();
                                j6 = this.a.U;
                                long j7 = e - j6;
                                gVar20 = this.a.I;
                                long c = gVar20.c();
                                gVar21 = this.a.I;
                                long d = gVar21.d();
                                gVar22 = this.a.I;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis - j5, j7, c, d, currentTimeMillis - gVar22.b());
                                this.a.U = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            gVar13 = this.a.I;
            if (gVar13 != null) {
                gVar15 = this.a.I;
                if (gVar15.i() != null) {
                    gVar16 = this.a.I;
                    if (gVar16.i().isBawu()) {
                        ctVar14 = this.a.w;
                        ctVar14.f(true);
                        this.a.H();
                        gVar14 = this.a.I;
                        if (!gVar14.f()) {
                            ctVar12 = this.a.w;
                            ctVar12.w().h();
                            ctVar13 = this.a.w;
                            ctVar13.x().g();
                        } else {
                            ctVar10 = this.a.w;
                            ctVar10.w().g();
                            ctVar11 = this.a.w;
                            ctVar11.x().f();
                        }
                    }
                }
            }
            ctVar9 = this.a.w;
            ctVar9.f(false);
            this.a.H();
            gVar14 = this.a.I;
            if (!gVar14.f()) {
            }
        } else {
            this.a.a(jVar);
        }
        this.a.x = null;
        j = this.a.U;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.U;
            gVar3 = this.a.I;
            long e2 = gVar3.e();
            j3 = this.a.U;
            long j8 = e2 - j3;
            gVar4 = this.a.I;
            long c2 = gVar4.c();
            gVar5 = this.a.I;
            long d2 = gVar5.d();
            gVar6 = this.a.I;
            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j2, j8, c2, d2, currentTimeMillis2 - gVar6.b());
            this.a.U = -1L;
        }
        FrsActivity frsActivity8 = this.a;
        gVar = this.a.I;
        frsActivity8.a(gVar);
        gVar2 = this.a.I;
        this.a.a(Boolean.valueOf(gVar2.j().isIfvoice()));
        System.gc();
    }

    @Override // com.baidu.tieba.frs.dh
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
