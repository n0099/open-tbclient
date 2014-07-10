package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
class at implements di {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.di
    public void a(int i) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        ct ctVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                ctVar3 = this.a.v;
                ctVar3.c(true);
                ctVar4 = this.a.v;
                ctVar4.y();
                return;
            case 2:
                ctVar = this.a.v;
                ctVar.d(true);
                ctVar2 = this.a.v;
                ctVar2.y();
                return;
            case 3:
                ctVar5 = this.a.v;
                ctVar5.b(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04bf  */
    @Override // com.baidu.tieba.frs.di
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
        boolean z2;
        boolean z3;
        g gVar8;
        boolean z4;
        String str;
        String str2;
        String str3;
        ct ctVar7;
        g gVar9;
        AdapterView.OnItemClickListener onItemClickListener;
        ct ctVar8;
        g gVar10;
        g gVar11;
        ct ctVar9;
        g gVar12;
        ct ctVar10;
        ct ctVar11;
        ct ctVar12;
        ct ctVar13;
        ct ctVar14;
        ct ctVar15;
        ct ctVar16;
        ct ctVar17;
        g gVar13;
        g gVar14;
        ct ctVar18;
        g gVar15;
        g gVar16;
        int i2;
        int i3;
        long j4;
        long j5;
        g gVar17;
        long j6;
        g gVar18;
        g gVar19;
        g gVar20;
        int i4;
        ct ctVar19;
        ct ctVar20;
        g gVar21;
        String str4;
        String str5;
        g gVar22;
        g gVar23;
        g gVar24;
        String str6;
        String str7;
        String str8;
        g gVar25;
        g gVar26;
        g gVar27;
        g gVar28;
        g gVar29;
        boolean z5;
        ct ctVar21;
        ct ctVar22;
        ct ctVar23;
        ct ctVar24;
        g gVar30;
        ct ctVar25;
        ct ctVar26;
        ct ctVar27;
        ct ctVar28;
        ct ctVar29;
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            ctVar29 = this.a.v;
            ctVar29.o();
        } else {
            ctVar = this.a.v;
            ctVar.p();
        }
        if (jVar != null && jVar.b) {
            ctVar28 = this.a.v;
            ctVar28.u().a(com.baidu.tbadk.core.util.bn.a().b());
            FrsActivity.z = 0L;
            FrsActivity.A = 0L;
            FrsActivity.B = 0;
        } else {
            FrsActivity.B = 1;
        }
        ctVar2 = this.a.v;
        ctVar2.b(false);
        switch (i) {
            case 1:
                ctVar5 = this.a.v;
                ctVar5.c(false);
                ctVar6 = this.a.v;
                ctVar6.y();
                break;
            case 2:
                ctVar3 = this.a.v;
                ctVar3.d(false);
                ctVar4 = this.a.v;
                ctVar4.y();
                break;
        }
        if (!z && (jVar == null || jVar.c == 0)) {
            gVar7 = this.a.H;
            if (gVar7 != null) {
                gVar28 = this.a.H;
                if (gVar28.l().a() == 1) {
                    this.a.N = "frs_page";
                } else {
                    this.a.N = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                gVar29 = this.a.H;
                frsActivity.m = gVar29.g().getName();
                z5 = this.a.D;
                if (!z5) {
                    ctVar21 = this.a.v;
                    ctVar21.ab().setVisibility(0);
                    ctVar22 = this.a.v;
                    ctVar22.ac().setVisibility(4);
                    ctVar23 = this.a.v;
                    ctVar23.ad().setVisibility(4);
                } else {
                    this.a.N = "good_page";
                    ctVar25 = this.a.v;
                    ctVar25.ab().setVisibility(4);
                    ctVar26 = this.a.v;
                    ctVar26.ac().setVisibility(0);
                    ctVar27 = this.a.v;
                    ctVar27.ad().setVisibility(4);
                }
                ctVar24 = this.a.v;
                gVar30 = this.a.H;
                ctVar24.a(gVar30.g());
            }
            z2 = this.a.ae;
            if (z2) {
                FrsActivity frsActivity2 = this.a;
                gVar25 = this.a.H;
                frsActivity2.b(gVar25);
                FrsActivity frsActivity3 = this.a;
                gVar26 = this.a.H;
                frsActivity3.d(gVar26);
                FrsActivity frsActivity4 = this.a;
                gVar27 = this.a.H;
                frsActivity4.c(gVar27);
            }
            z3 = this.a.F;
            if (z3) {
                LimitList hasShowAppForums = TbadkApplication.m252getInst().getHasShowAppForums();
                str4 = this.a.m;
                if (!hasShowAppForums.contains(str4)) {
                    this.a.F = false;
                    LimitList hasShowAppForums2 = TbadkApplication.m252getInst().getHasShowAppForums();
                    str5 = this.a.m;
                    hasShowAppForums2.add(str5);
                    gVar22 = this.a.H;
                    if (gVar22 != null) {
                        gVar23 = this.a.H;
                        if (gVar23.g() != null) {
                            gVar24 = this.a.H;
                            com.baidu.tbadk.core.data.c bannerListData = gVar24.g().getBannerListData();
                            if (bannerListData != null && bannerListData.a() != null) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 < bannerListData.a().size()) {
                                        FrsActivity frsActivity5 = this.a;
                                        str7 = frsActivity5.V;
                                        frsActivity5.V = String.valueOf(str7) + bannerListData.a().get(i6).i();
                                        if (i6 < bannerListData.a().size() - 1) {
                                            FrsActivity frsActivity6 = this.a;
                                            str8 = frsActivity6.V;
                                            frsActivity6.V = String.valueOf(str8) + "|";
                                        }
                                        i5 = i6 + 1;
                                    } else {
                                        FrsActivity frsActivity7 = this.a;
                                        str6 = this.a.V;
                                        TiebaStatic.eventStat(frsActivity7, "frs_show_app", "frs_recommend_app", 1, "app_name", str6);
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
            gVar8 = this.a.H;
            com.baidu.tbadk.core.data.n top_notice_data = gVar8.g().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.c(top_notice_data.a());
                mVar.c(2);
                mVar.b(top_notice_data.b());
                mVar.L();
                gVar21 = this.a.H;
                gVar21.a(mVar);
            }
            z4 = this.a.E;
            if (z4) {
                ctVar20 = this.a.v;
                ctVar20.I();
                this.a.E = false;
            }
            str = this.a.N;
            if (str.equals("frs_page")) {
                ctVar19 = this.a.v;
                ctVar19.A();
            } else {
                str2 = this.a.N;
                if (str2.equals("normal_page")) {
                    ctVar8 = this.a.v;
                    ctVar8.z();
                } else {
                    str3 = this.a.N;
                    if (str3.equals("good_page")) {
                        ctVar7 = this.a.v;
                        gVar9 = this.a.H;
                        ArrayList<com.baidu.tbadk.core.data.g> good_classify = gVar9.g().getGood_classify();
                        onItemClickListener = this.a.ay;
                        ctVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.z = (System.nanoTime() - this.b) / 1000000;
            if (jVar != null) {
                FrsActivity.A = jVar.e;
            }
            gVar10 = this.a.H;
            if (gVar10 != null) {
                gVar15 = this.a.H;
                if (gVar15.h() != null) {
                    gVar16 = this.a.H;
                    if (gVar16.h().size() == 0) {
                        i2 = this.a.l;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(com.baidu.tieba.y.no_more_to_load));
                            i3 = this.a.p;
                            if (i3 > 1) {
                                FrsActivity frsActivity8 = this.a;
                                i4 = frsActivity8.p;
                                frsActivity8.p = i4 - 1;
                            }
                            j4 = this.a.T;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.a.T;
                                gVar17 = this.a.H;
                                long e = gVar17.e();
                                j6 = this.a.T;
                                long j7 = e - j6;
                                gVar18 = this.a.H;
                                long c = gVar18.c();
                                gVar19 = this.a.H;
                                long d = gVar19.d();
                                gVar20 = this.a.H;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis - j5, j7, c, d, currentTimeMillis - gVar20.b());
                                this.a.T = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            gVar11 = this.a.H;
            if (gVar11 != null) {
                gVar13 = this.a.H;
                if (gVar13.i() != null) {
                    gVar14 = this.a.H;
                    if (gVar14.i().isBawu()) {
                        ctVar18 = this.a.v;
                        ctVar18.f(true);
                        this.a.H();
                        gVar12 = this.a.H;
                        if (!gVar12.f()) {
                            ctVar14 = this.a.v;
                            if (ctVar14.v() != null) {
                                ctVar17 = this.a.v;
                                ctVar17.v().h();
                            }
                            ctVar15 = this.a.v;
                            if (ctVar15.w() != null) {
                                ctVar16 = this.a.v;
                                ctVar16.w().g();
                            }
                        } else {
                            ctVar10 = this.a.v;
                            if (ctVar10.v() != null) {
                                ctVar13 = this.a.v;
                                ctVar13.v().g();
                            }
                            ctVar11 = this.a.v;
                            if (ctVar11.w() != null) {
                                ctVar12 = this.a.v;
                                ctVar12.w().f();
                            }
                        }
                    }
                }
            }
            ctVar9 = this.a.v;
            ctVar9.f(false);
            this.a.H();
            gVar12 = this.a.H;
            if (!gVar12.f()) {
            }
        } else {
            this.a.a(jVar);
        }
        this.a.w = null;
        j = this.a.T;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.T;
            gVar3 = this.a.H;
            long e2 = gVar3.e();
            j3 = this.a.T;
            long j8 = e2 - j3;
            gVar4 = this.a.H;
            long c2 = gVar4.c();
            gVar5 = this.a.H;
            long d2 = gVar5.d();
            gVar6 = this.a.H;
            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j2, j8, c2, d2, currentTimeMillis2 - gVar6.b());
            this.a.T = -1L;
        }
        FrsActivity frsActivity9 = this.a;
        gVar = this.a.H;
        frsActivity9.a(gVar);
        gVar2 = this.a.H;
        this.a.a(Boolean.valueOf(gVar2.j().isIfvoice()));
        System.gc();
    }

    @Override // com.baidu.tieba.frs.di
    public void a(g gVar) {
        String str;
        String str2;
        if (gVar != null) {
            str = this.a.N;
            if (!str.equals("normal_page")) {
                str2 = this.a.N;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.a.e(gVar);
        }
    }
}
