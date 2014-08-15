package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.LimitList;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
class aw implements dl {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(int i) {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        cu cuVar4;
        cu cuVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                cuVar3 = this.a.z;
                cuVar3.c(true);
                cuVar4 = this.a.z;
                cuVar4.z();
                return;
            case 2:
                cuVar = this.a.z;
                cuVar.d(true);
                cuVar2 = this.a.z;
                cuVar2.z();
                return;
            case 3:
                cuVar5 = this.a.z;
                cuVar5.b(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x054a  */
    @Override // com.baidu.tieba.frs.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, j jVar) {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        cu cuVar4;
        cu cuVar5;
        cu cuVar6;
        long j;
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        long j2;
        g gVar6;
        long j3;
        g gVar7;
        g gVar8;
        g gVar9;
        g gVar10;
        boolean z2;
        boolean z3;
        g gVar11;
        boolean z4;
        String str;
        String str2;
        String str3;
        cu cuVar7;
        g gVar12;
        AdapterView.OnItemClickListener onItemClickListener;
        cu cuVar8;
        g gVar13;
        g gVar14;
        g gVar15;
        g gVar16;
        cu cuVar9;
        g gVar17;
        cu cuVar10;
        cu cuVar11;
        cu cuVar12;
        cu cuVar13;
        cu cuVar14;
        cu cuVar15;
        cu cuVar16;
        cu cuVar17;
        g gVar18;
        g gVar19;
        cu cuVar18;
        g gVar20;
        g gVar21;
        int i2;
        int i3;
        long j4;
        long j5;
        g gVar22;
        long j6;
        g gVar23;
        g gVar24;
        g gVar25;
        int i4;
        cu cuVar19;
        g gVar26;
        g gVar27;
        cu cuVar20;
        cu cuVar21;
        View.OnClickListener onClickListener;
        cu cuVar22;
        View.OnClickListener onClickListener2;
        g gVar28;
        cu cuVar23;
        g gVar29;
        cu cuVar24;
        g gVar30;
        int d;
        String str4;
        String str5;
        g gVar31;
        g gVar32;
        g gVar33;
        String str6;
        String str7;
        String str8;
        g gVar34;
        g gVar35;
        g gVar36;
        g gVar37;
        g gVar38;
        boolean z5;
        cu cuVar25;
        boolean z6;
        cu cuVar26;
        g gVar39;
        g gVar40;
        cu cuVar27;
        cu cuVar28;
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            cuVar28 = this.a.z;
            cuVar28.p();
        } else {
            cuVar = this.a.z;
            cuVar.q();
        }
        if (jVar != null && jVar.b) {
            cuVar27 = this.a.z;
            cuVar27.v().a(com.baidu.tbadk.core.util.bb.a().b());
            FrsActivity.D = 0L;
            FrsActivity.E = 0L;
            FrsActivity.F = 0;
        } else {
            FrsActivity.F = 1;
        }
        cuVar2 = this.a.z;
        cuVar2.b(false);
        switch (i) {
            case 1:
                cuVar5 = this.a.z;
                cuVar5.c(false);
                cuVar6 = this.a.z;
                cuVar6.z();
                break;
            case 2:
                cuVar3 = this.a.z;
                cuVar3.d(false);
                cuVar4 = this.a.z;
                cuVar4.z();
                break;
        }
        if (!z && (jVar == null || jVar.c == 0)) {
            gVar10 = this.a.L;
            if (gVar10 != null) {
                gVar37 = this.a.L;
                if (gVar37.n().a() == 1) {
                    this.a.R = "frs_page";
                } else {
                    this.a.R = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                gVar38 = this.a.L;
                frsActivity.q = gVar38.i().getName();
                z5 = this.a.H;
                if (z5) {
                    this.a.R = "good_page";
                }
                cuVar25 = this.a.z;
                z6 = this.a.H;
                cuVar25.e(z6);
                cuVar26 = this.a.z;
                gVar39 = this.a.L;
                ForumData i5 = gVar39.i();
                gVar40 = this.a.L;
                cuVar26.a(i5, gVar40.k());
            }
            z2 = this.a.ag;
            if (z2) {
                FrsActivity frsActivity2 = this.a;
                gVar34 = this.a.L;
                frsActivity2.b(gVar34);
                FrsActivity frsActivity3 = this.a;
                gVar35 = this.a.L;
                frsActivity3.e(gVar35);
                FrsActivity frsActivity4 = this.a;
                gVar36 = this.a.L;
                frsActivity4.c(gVar36);
            }
            z3 = this.a.J;
            if (z3) {
                LimitList hasShowAppForums = TbadkApplication.m252getInst().getHasShowAppForums();
                str4 = this.a.q;
                if (!hasShowAppForums.contains(str4)) {
                    this.a.J = false;
                    LimitList hasShowAppForums2 = TbadkApplication.m252getInst().getHasShowAppForums();
                    str5 = this.a.q;
                    hasShowAppForums2.add(str5);
                    gVar31 = this.a.L;
                    if (gVar31 != null) {
                        gVar32 = this.a.L;
                        if (gVar32.i() != null) {
                            gVar33 = this.a.L;
                            com.baidu.tbadk.core.data.d bannerListData = gVar33.i().getBannerListData();
                            if (bannerListData != null && bannerListData.a() != null) {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 < bannerListData.a().size()) {
                                        FrsActivity frsActivity5 = this.a;
                                        str7 = frsActivity5.Y;
                                        frsActivity5.Y = String.valueOf(str7) + bannerListData.a().get(i7).g;
                                        if (i7 < bannerListData.a().size() - 1) {
                                            FrsActivity frsActivity6 = this.a;
                                            str8 = frsActivity6.Y;
                                            frsActivity6.Y = String.valueOf(str8) + "|";
                                        }
                                        i6 = i7 + 1;
                                    } else {
                                        FrsActivity frsActivity7 = this.a;
                                        str6 = this.a.Y;
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
            gVar11 = this.a.L;
            com.baidu.tbadk.core.data.o top_notice_data = gVar11.i().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                nVar.c(top_notice_data.a());
                nVar.b(2);
                nVar.b(top_notice_data.b());
                nVar.D();
                gVar28 = this.a.L;
                gVar28.a(nVar);
                cuVar23 = this.a.z;
                if (cuVar23.v() != null) {
                    gVar29 = this.a.L;
                    ArrayList<LiveCardData> c = gVar29.c();
                    if (c != null && c.size() > 0) {
                        cuVar24 = this.a.z;
                        bc v = cuVar24.v();
                        FrsActivity frsActivity8 = this.a;
                        gVar30 = this.a.L;
                        d = frsActivity8.d(gVar30);
                        v.a(d);
                    }
                }
            }
            z4 = this.a.I;
            if (z4) {
                cuVar20 = this.a.z;
                cuVar20.H();
                cuVar21 = this.a.z;
                bc v2 = cuVar21.v();
                onClickListener = this.a.aA;
                v2.a(onClickListener);
                cuVar22 = this.a.z;
                bc v3 = cuVar22.v();
                onClickListener2 = this.a.aB;
                v3.b(onClickListener2);
                this.a.I = false;
            }
            str = this.a.R;
            if (str.equals("frs_page")) {
                cuVar19 = this.a.z;
                gVar26 = this.a.L;
                int isMem = gVar26.k().getIsMem();
                gVar27 = this.a.L;
                cuVar19.b(isMem, gVar27.i().isLike());
            } else {
                str2 = this.a.R;
                if (str2.equals("normal_page")) {
                    cuVar8 = this.a.z;
                    gVar13 = this.a.L;
                    int isMem2 = gVar13.k().getIsMem();
                    gVar14 = this.a.L;
                    cuVar8.a(isMem2, gVar14.i().isLike());
                } else {
                    str3 = this.a.R;
                    if (str3.equals("good_page")) {
                        cuVar7 = this.a.z;
                        gVar12 = this.a.L;
                        ArrayList<com.baidu.tbadk.core.data.h> good_classify = gVar12.i().getGood_classify();
                        onItemClickListener = this.a.aC;
                        cuVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.D = (System.nanoTime() - this.b) / 1000000;
            if (jVar != null) {
                FrsActivity.E = jVar.e;
            }
            gVar15 = this.a.L;
            if (gVar15 != null) {
                gVar20 = this.a.L;
                if (gVar20.j() != null) {
                    gVar21 = this.a.L;
                    if (gVar21.j().size() == 0) {
                        i2 = this.a.p;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(com.baidu.tieba.x.no_more_to_load));
                            i3 = this.a.t;
                            if (i3 > 1) {
                                FrsActivity frsActivity9 = this.a;
                                i4 = frsActivity9.t;
                                frsActivity9.t = i4 - 1;
                            }
                            j4 = this.a.X;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.a.X;
                                gVar22 = this.a.L;
                                long g = gVar22.g();
                                j6 = this.a.X;
                                long j7 = g - j6;
                                gVar23 = this.a.L;
                                long e = gVar23.e();
                                gVar24 = this.a.L;
                                long f = gVar24.f();
                                gVar25 = this.a.L;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis - j5, j7, e, f, currentTimeMillis - gVar25.d());
                                this.a.X = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            gVar16 = this.a.L;
            if (gVar16 != null) {
                gVar18 = this.a.L;
                if (gVar18.k() != null) {
                    gVar19 = this.a.L;
                    if (gVar19.k().isBawu()) {
                        cuVar18 = this.a.z;
                        cuVar18.g(true);
                        this.a.F();
                        gVar17 = this.a.L;
                        if (!gVar17.h()) {
                            cuVar14 = this.a.z;
                            if (cuVar14.w() != null) {
                                cuVar17 = this.a.z;
                                cuVar17.w().k();
                            }
                            cuVar15 = this.a.z;
                            if (cuVar15.x() != null) {
                                cuVar16 = this.a.z;
                                cuVar16.x().l();
                            }
                        } else {
                            cuVar10 = this.a.z;
                            if (cuVar10.w() != null) {
                                cuVar13 = this.a.z;
                                cuVar13.w().j();
                            }
                            cuVar11 = this.a.z;
                            if (cuVar11.x() != null) {
                                cuVar12 = this.a.z;
                                cuVar12.x().k();
                            }
                        }
                    }
                }
            }
            cuVar9 = this.a.z;
            cuVar9.g(false);
            this.a.F();
            gVar17 = this.a.L;
            if (!gVar17.h()) {
            }
        } else {
            this.a.a(jVar);
        }
        this.a.A = null;
        j = this.a.X;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.X;
            gVar6 = this.a.L;
            long g2 = gVar6.g();
            j3 = this.a.X;
            long j8 = g2 - j3;
            gVar7 = this.a.L;
            long e2 = gVar7.e();
            gVar8 = this.a.L;
            long f2 = gVar8.f();
            gVar9 = this.a.L;
            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j2, j8, e2, f2, currentTimeMillis2 - gVar9.d());
            this.a.X = -1L;
        }
        FrsActivity frsActivity10 = this.a;
        gVar = this.a.L;
        frsActivity10.a(gVar);
        gVar2 = this.a.L;
        this.a.a(Boolean.valueOf(gVar2.l().isIfvoice()));
        gVar3 = this.a.L;
        if (gVar3 != null) {
            gVar4 = this.a.L;
            if (gVar4.k() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                gVar5 = this.a.L;
                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(gVar5.k().getIsMem())));
            }
        }
        System.gc();
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(g gVar) {
        String str;
        String str2;
        if (gVar != null) {
            str = this.a.R;
            if (!str.equals("normal_page")) {
                str2 = this.a.R;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.a.f(gVar);
        }
    }
}
