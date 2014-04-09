package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class x implements cz {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cz
    public final void a(int i) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        cm cmVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                cmVar3 = this.a.r;
                cmVar3.d(true);
                cmVar4 = this.a.r;
                cmVar4.y();
                return;
            case 2:
                cmVar = this.a.r;
                cmVar.e(true);
                cmVar2 = this.a.r;
                cmVar2.y();
                return;
            case 3:
                cmVar5 = this.a.r;
                cmVar5.c(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x045b  */
    @Override // com.baidu.tieba.frs.cz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i, JSONObject jSONObject, j jVar) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        cm cmVar5;
        cm cmVar6;
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
        boolean z;
        g gVar8;
        boolean z2;
        String str;
        String str2;
        String str3;
        cm cmVar7;
        g gVar9;
        AdapterView.OnItemClickListener onItemClickListener;
        cm cmVar8;
        g gVar10;
        g gVar11;
        cm cmVar9;
        g gVar12;
        cm cmVar10;
        cm cmVar11;
        cm cmVar12;
        cm cmVar13;
        g gVar13;
        g gVar14;
        cm cmVar14;
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
        cm cmVar15;
        cm cmVar16;
        g gVar21;
        String str4;
        g gVar22;
        String str5;
        g gVar23;
        g gVar24;
        g gVar25;
        String str6;
        String str7;
        String str8;
        g gVar26;
        g gVar27;
        boolean z3;
        cm cmVar17;
        cm cmVar18;
        cm cmVar19;
        cm cmVar20;
        g gVar28;
        cm cmVar21;
        cm cmVar22;
        cm cmVar23;
        cm cmVar24;
        cm cmVar25;
        if (UtilHelper.d(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            cmVar25 = this.a.r;
            cmVar25.p();
        } else {
            cmVar = this.a.r;
            cmVar.q();
        }
        if (jVar != null && jVar.b) {
            cmVar24 = this.a.r;
            cmVar24.u().a(com.baidu.tbadk.core.util.bd.a().b());
            FrsActivity.v = 0L;
            FrsActivity.w = 0L;
            FrsActivity.x = 0;
        } else {
            FrsActivity.x = 1;
        }
        cmVar2 = this.a.r;
        cmVar2.c(false);
        switch (i) {
            case 1:
                cmVar5 = this.a.r;
                cmVar5.d(false);
                cmVar6 = this.a.r;
                cmVar6.y();
                break;
            case 2:
                cmVar3 = this.a.r;
                cmVar3.e(false);
                cmVar4 = this.a.r;
                cmVar4.y();
                break;
        }
        if (jSONObject != null && (jVar == null || jVar.c == 0)) {
            gVar7 = this.a.D;
            if (gVar7 != null) {
                gVar26 = this.a.D;
                if (gVar26.k().a() == 1) {
                    this.a.J = "frs_page";
                } else {
                    this.a.J = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                gVar27 = this.a.D;
                frsActivity.i = gVar27.f().getName();
                z3 = this.a.z;
                if (!z3) {
                    cmVar17 = this.a.r;
                    cmVar17.S().setVisibility(0);
                    cmVar18 = this.a.r;
                    cmVar18.T().setVisibility(4);
                    cmVar19 = this.a.r;
                    cmVar19.U().setVisibility(4);
                } else {
                    this.a.J = "good_page";
                    cmVar21 = this.a.r;
                    cmVar21.S().setVisibility(4);
                    cmVar22 = this.a.r;
                    cmVar22.T().setVisibility(0);
                    cmVar23 = this.a.r;
                    cmVar23.U().setVisibility(4);
                }
                cmVar20 = this.a.r;
                gVar28 = this.a.D;
                cmVar20.a(gVar28.f());
            }
            z = this.a.B;
            if (z) {
                LimitList v = TbadkApplication.j().v();
                str4 = this.a.i;
                if (!v.contains(str4)) {
                    FrsActivity frsActivity2 = this.a;
                    gVar22 = this.a.D;
                    frsActivity2.a(gVar22);
                    this.a.B = false;
                    LimitList v2 = TbadkApplication.j().v();
                    str5 = this.a.i;
                    v2.add(str5);
                    gVar23 = this.a.D;
                    if (gVar23 != null) {
                        gVar24 = this.a.D;
                        if (gVar24.f() != null) {
                            gVar25 = this.a.D;
                            com.baidu.tbadk.core.data.c bannerListData = gVar25.f().getBannerListData();
                            if (bannerListData != null && bannerListData.a() != null) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 < bannerListData.a().size()) {
                                        FrsActivity frsActivity3 = this.a;
                                        str7 = frsActivity3.Q;
                                        frsActivity3.Q = String.valueOf(str7) + bannerListData.a().get(i6).e();
                                        if (i6 < bannerListData.a().size() - 1) {
                                            FrsActivity frsActivity4 = this.a;
                                            str8 = frsActivity4.Q;
                                            frsActivity4.Q = String.valueOf(str8) + "|";
                                        }
                                        i5 = i6 + 1;
                                    } else {
                                        FrsActivity frsActivity5 = this.a;
                                        str6 = this.a.Q;
                                        TiebaStatic.a(frsActivity5, "frs_show_app", "frs_recommend_app", 1, "app_name", str6);
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
            gVar8 = this.a.D;
            com.baidu.tbadk.core.data.p top_notice_data = gVar8.f().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                oVar.c(top_notice_data.a());
                oVar.c(2);
                oVar.b(top_notice_data.b());
                oVar.E();
                gVar21 = this.a.D;
                gVar21.g().add(0, oVar);
            }
            z2 = this.a.A;
            if (z2) {
                cmVar16 = this.a.r;
                cmVar16.H();
                this.a.A = false;
            }
            str = this.a.J;
            if (str.equals("frs_page")) {
                cmVar15 = this.a.r;
                cmVar15.A();
            } else {
                str2 = this.a.J;
                if (str2.equals("normal_page")) {
                    cmVar8 = this.a.r;
                    cmVar8.z();
                } else {
                    str3 = this.a.J;
                    if (str3.equals("good_page")) {
                        cmVar7 = this.a.r;
                        gVar9 = this.a.D;
                        ArrayList<com.baidu.tbadk.core.data.g> good_classify = gVar9.f().getGood_classify();
                        onItemClickListener = this.a.as;
                        cmVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.v = (System.nanoTime() - this.b) / 1000000;
            if (jVar != null) {
                FrsActivity.w = jVar.e;
            }
            gVar10 = this.a.D;
            if (gVar10 != null) {
                gVar15 = this.a.D;
                if (gVar15.g() != null) {
                    gVar16 = this.a.D;
                    if (gVar16.g().size() == 0) {
                        i2 = this.a.h;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(com.baidu.tieba.a.k.no_more_to_load));
                            i3 = this.a.l;
                            if (i3 > 1) {
                                FrsActivity frsActivity6 = this.a;
                                i4 = frsActivity6.l;
                                frsActivity6.l = i4 - 1;
                            }
                            j4 = this.a.O;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.a.O;
                                gVar17 = this.a.D;
                                long d = gVar17.d();
                                j6 = this.a.O;
                                long j7 = d - j6;
                                gVar18 = this.a.D;
                                long b = gVar18.b();
                                gVar19 = this.a.D;
                                long c = gVar19.c();
                                gVar20 = this.a.D;
                                TiebaStatic.a("op_frs_enter", currentTimeMillis - j5, j7, b, c, currentTimeMillis - gVar20.a());
                                this.a.O = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            gVar11 = this.a.D;
            if (gVar11 != null) {
                gVar13 = this.a.D;
                if (gVar13.h() != null) {
                    gVar14 = this.a.D;
                    if (gVar14.h().getIsManager()) {
                        cmVar14 = this.a.r;
                        cmVar14.g(true);
                        FrsActivity.q(this.a);
                        gVar12 = this.a.D;
                        if (!gVar12.e()) {
                            cmVar12 = this.a.r;
                            cmVar12.v().j();
                            cmVar13 = this.a.r;
                            cmVar13.w().i();
                        } else {
                            cmVar10 = this.a.r;
                            cmVar10.v().i();
                            cmVar11 = this.a.r;
                            cmVar11.w().h();
                        }
                    }
                }
            }
            cmVar9 = this.a.r;
            cmVar9.g(false);
            FrsActivity.q(this.a);
            gVar12 = this.a.D;
            if (!gVar12.e()) {
            }
        } else {
            FrsActivity.a(this.a, jVar);
        }
        this.a.s = null;
        j = this.a.O;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.O;
            gVar3 = this.a.D;
            long d2 = gVar3.d();
            j3 = this.a.O;
            long j8 = d2 - j3;
            gVar4 = this.a.D;
            long b2 = gVar4.b();
            gVar5 = this.a.D;
            long c2 = gVar5.c();
            gVar6 = this.a.D;
            TiebaStatic.a("op_frs_enter", currentTimeMillis2 - j2, j8, b2, c2, currentTimeMillis2 - gVar6.a());
            this.a.O = -1L;
        }
        FrsActivity frsActivity7 = this.a;
        gVar = this.a.D;
        FrsActivity.b(frsActivity7, gVar);
        gVar2 = this.a.D;
        FrsActivity.a(this.a, Boolean.valueOf(gVar2.i().isIfvoice()));
        System.gc();
    }

    @Override // com.baidu.tieba.frs.cz
    public final void a(g gVar) {
        String str;
        String str2;
        if (gVar != null) {
            str = this.a.J;
            if (!str.equals("normal_page")) {
                str2 = this.a.J;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            FrsActivity.c(this.a, gVar);
        }
    }
}
