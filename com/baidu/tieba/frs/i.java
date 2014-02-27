package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.util.LimitList;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class i implements bz {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.bz
    public final void a(int i) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                bsVar3 = this.a.p;
                bsVar3.d(true);
                bsVar4 = this.a.p;
                bsVar4.q();
                return;
            case 2:
                bsVar = this.a.p;
                bsVar.e(true);
                bsVar2 = this.a.p;
                bsVar2.q();
                return;
            case 3:
                bsVar5 = this.a.p;
                bsVar5.c(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03e4  */
    @Override // com.baidu.tieba.frs.bz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ac acVar) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        long j;
        long j2;
        com.baidu.tieba.model.z zVar;
        long j3;
        com.baidu.tieba.model.z zVar2;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        com.baidu.tieba.model.z zVar5;
        boolean z;
        com.baidu.tieba.model.z zVar6;
        boolean z2;
        String str;
        String str2;
        String str3;
        bs bsVar7;
        com.baidu.tieba.model.z zVar7;
        AdapterView.OnItemClickListener onItemClickListener;
        bs bsVar8;
        com.baidu.tieba.model.z zVar8;
        com.baidu.tieba.model.z zVar9;
        bs bsVar9;
        com.baidu.tieba.model.z zVar10;
        bs bsVar10;
        bs bsVar11;
        bs bsVar12;
        bs bsVar13;
        com.baidu.tieba.model.z zVar11;
        com.baidu.tieba.model.z zVar12;
        bs bsVar14;
        com.baidu.tieba.model.z zVar13;
        com.baidu.tieba.model.z zVar14;
        int i2;
        int i3;
        long j4;
        long j5;
        com.baidu.tieba.model.z zVar15;
        long j6;
        com.baidu.tieba.model.z zVar16;
        com.baidu.tieba.model.z zVar17;
        com.baidu.tieba.model.z zVar18;
        int i4;
        bs bsVar15;
        bs bsVar16;
        com.baidu.tieba.model.z zVar19;
        String str4;
        com.baidu.tieba.model.z zVar20;
        String str5;
        com.baidu.tieba.model.z zVar21;
        com.baidu.tieba.model.z zVar22;
        com.baidu.tieba.model.z zVar23;
        String str6;
        String str7;
        String str8;
        com.baidu.tieba.model.z zVar24;
        com.baidu.tieba.model.z zVar25;
        boolean z3;
        bs bsVar17;
        com.baidu.tieba.model.z zVar26;
        bs bsVar18;
        bs bsVar19;
        if (UtilHelper.h(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bsVar19 = this.a.p;
            bsVar19.h();
        } else {
            bsVar = this.a.p;
            bsVar.i();
        }
        if (acVar != null && acVar.b) {
            bsVar18 = this.a.p;
            bsVar18.m().a(com.baidu.tieba.util.bv.a().b());
            FrsActivity.s = 0L;
            FrsActivity.t = 0L;
            FrsActivity.u = 0;
        } else {
            FrsActivity.u = 1;
        }
        bsVar2 = this.a.p;
        bsVar2.c(false);
        switch (i) {
            case 1:
                bsVar5 = this.a.p;
                bsVar5.d(false);
                bsVar6 = this.a.p;
                bsVar6.q();
                break;
            case 2:
                bsVar3 = this.a.p;
                bsVar3.e(false);
                bsVar4 = this.a.p;
                bsVar4.q();
                break;
        }
        if (jSONObject != null && (acVar == null || acVar.c == 0)) {
            zVar5 = this.a.A;
            if (zVar5 != null) {
                zVar24 = this.a.A;
                if (zVar24.k().a() == 1) {
                    this.a.G = "frs_page";
                } else {
                    this.a.G = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                zVar25 = this.a.A;
                frsActivity.g = zVar25.f().getName();
                z3 = this.a.w;
                if (z3) {
                    this.a.G = "good_page";
                }
                bsVar17 = this.a.p;
                zVar26 = this.a.A;
                bsVar17.a(zVar26.f());
            }
            z = this.a.y;
            if (z) {
                LimitList bj = TiebaApplication.g().bj();
                str4 = this.a.g;
                if (!bj.contains(str4)) {
                    FrsActivity frsActivity2 = this.a;
                    zVar20 = this.a.A;
                    frsActivity2.a(zVar20);
                    this.a.y = false;
                    LimitList bj2 = TiebaApplication.g().bj();
                    str5 = this.a.g;
                    bj2.add(str5);
                    zVar21 = this.a.A;
                    if (zVar21 != null) {
                        zVar22 = this.a.A;
                        if (zVar22.f() != null) {
                            zVar23 = this.a.A;
                            h bannerListData = zVar23.f().getBannerListData();
                            if (bannerListData != null && bannerListData.a() != null) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 < bannerListData.a().size()) {
                                        FrsActivity frsActivity3 = this.a;
                                        str7 = frsActivity3.S;
                                        frsActivity3.S = String.valueOf(str7) + bannerListData.a().get(i6).v();
                                        if (i6 < bannerListData.a().size() - 1) {
                                            FrsActivity frsActivity4 = this.a;
                                            str8 = frsActivity4.S;
                                            frsActivity4.S = String.valueOf(str8) + "|";
                                        }
                                        i5 = i6 + 1;
                                    } else {
                                        FrsActivity frsActivity5 = this.a;
                                        str6 = this.a.S;
                                        com.baidu.tieba.util.cb.a(frsActivity5, "frs_show_app", "frs_recommend_app", 1, "app_name", str6);
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
            zVar6 = this.a.A;
            com.baidu.tieba.data.bb top_notice_data = zVar6.f().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                azVar.c(top_notice_data.a());
                azVar.a(2);
                azVar.b(top_notice_data.b());
                azVar.q();
                zVar19 = this.a.A;
                zVar19.g().add(0, azVar);
            }
            z2 = this.a.x;
            if (z2) {
                bsVar16 = this.a.p;
                bsVar16.z();
                this.a.x = false;
            }
            str = this.a.G;
            if (str.equals("frs_page")) {
                bsVar15 = this.a.p;
                bsVar15.s();
            } else {
                str2 = this.a.G;
                if (str2.equals("normal_page")) {
                    bsVar8 = this.a.p;
                    bsVar8.r();
                } else {
                    str3 = this.a.G;
                    if (str3.equals("good_page")) {
                        bsVar7 = this.a.p;
                        zVar7 = this.a.A;
                        ArrayList<com.baidu.tieba.data.z> good_classify = zVar7.f().getGood_classify();
                        onItemClickListener = this.a.al;
                        bsVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.s = (System.nanoTime() - this.b) / 1000000;
            if (acVar != null) {
                FrsActivity.t = acVar.e;
            }
            zVar8 = this.a.A;
            if (zVar8 != null) {
                zVar13 = this.a.A;
                if (zVar13.g() != null) {
                    zVar14 = this.a.A;
                    if (zVar14.g().size() == 0) {
                        i2 = this.a.f;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(R.string.no_more_to_load));
                            i3 = this.a.j;
                            if (i3 > 1) {
                                FrsActivity frsActivity6 = this.a;
                                i4 = frsActivity6.j;
                                frsActivity6.j = i4 - 1;
                            }
                            j4 = this.a.P;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.a.P;
                                zVar15 = this.a.A;
                                long d = zVar15.d();
                                j6 = this.a.P;
                                long j7 = d - j6;
                                zVar16 = this.a.A;
                                long b = zVar16.b();
                                zVar17 = this.a.A;
                                long c = zVar17.c();
                                zVar18 = this.a.A;
                                com.baidu.tieba.util.cb.a("op_frs_enter", currentTimeMillis - j5, j7, b, c, currentTimeMillis - zVar18.a());
                                this.a.P = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            zVar9 = this.a.A;
            if (zVar9 != null) {
                zVar11 = this.a.A;
                if (zVar11.h() != null) {
                    zVar12 = this.a.A;
                    if (zVar12.h().getIsManager()) {
                        bsVar14 = this.a.p;
                        bsVar14.g(true);
                        FrsActivity.m(this.a);
                        zVar10 = this.a.A;
                        if (!zVar10.e()) {
                            bsVar12 = this.a.p;
                            bsVar12.n().j();
                            bsVar13 = this.a.p;
                            bsVar13.o().i();
                        } else {
                            bsVar10 = this.a.p;
                            bsVar10.n().i();
                            bsVar11 = this.a.p;
                            bsVar11.o().h();
                        }
                    }
                }
            }
            bsVar9 = this.a.p;
            bsVar9.g(false);
            FrsActivity.m(this.a);
            zVar10 = this.a.A;
            if (!zVar10.e()) {
            }
        } else {
            FrsActivity.a(this.a, acVar);
        }
        this.a.q = null;
        j = this.a.P;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.P;
            zVar = this.a.A;
            long d2 = zVar.d();
            j3 = this.a.P;
            long j8 = d2 - j3;
            zVar2 = this.a.A;
            long b2 = zVar2.b();
            zVar3 = this.a.A;
            long c2 = zVar3.c();
            zVar4 = this.a.A;
            com.baidu.tieba.util.cb.a("op_frs_enter", currentTimeMillis2 - j2, j8, b2, c2, currentTimeMillis2 - zVar4.a());
            this.a.P = -1L;
        }
        System.gc();
    }

    @Override // com.baidu.tieba.frs.bz
    public final void a(com.baidu.tieba.model.z zVar) {
        String str;
        String str2;
        if (zVar != null) {
            str = this.a.G;
            if (!str.equals("normal_page")) {
                str2 = this.a.G;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            FrsActivity.b(this.a, zVar);
        }
    }
}
