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
class ax implements dn {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dn
    public void a(int i) {
        cv cvVar;
        cv cvVar2;
        cv cvVar3;
        cv cvVar4;
        cv cvVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                cvVar3 = this.a.B;
                cvVar3.c(true);
                cvVar4 = this.a.B;
                cvVar4.z();
                return;
            case 2:
                cvVar = this.a.B;
                cvVar.d(true);
                cvVar2 = this.a.B;
                cvVar2.z();
                return;
            case 3:
                cvVar5 = this.a.B;
                cvVar5.b(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x055d  */
    @Override // com.baidu.tieba.frs.dn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, j jVar) {
        cv cvVar;
        cv cvVar2;
        cv cvVar3;
        cv cvVar4;
        cv cvVar5;
        cv cvVar6;
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
        cv cvVar7;
        g gVar12;
        AdapterView.OnItemClickListener onItemClickListener;
        cv cvVar8;
        g gVar13;
        g gVar14;
        g gVar15;
        g gVar16;
        cv cvVar9;
        g gVar17;
        cv cvVar10;
        cv cvVar11;
        cv cvVar12;
        cv cvVar13;
        cv cvVar14;
        cv cvVar15;
        cv cvVar16;
        cv cvVar17;
        g gVar18;
        g gVar19;
        cv cvVar18;
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
        cv cvVar19;
        g gVar26;
        g gVar27;
        cv cvVar20;
        cv cvVar21;
        View.OnClickListener onClickListener;
        cv cvVar22;
        View.OnClickListener onClickListener2;
        g gVar28;
        cv cvVar23;
        g gVar29;
        cv cvVar24;
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
        g gVar39;
        boolean z5;
        cv cvVar25;
        boolean z6;
        cv cvVar26;
        g gVar40;
        g gVar41;
        cv cvVar27;
        cv cvVar28;
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            cvVar28 = this.a.B;
            cvVar28.p();
        } else {
            cvVar = this.a.B;
            cvVar.q();
        }
        if (jVar != null && jVar.b) {
            cvVar27 = this.a.B;
            cvVar27.v().a(com.baidu.tbadk.core.util.bb.a().b());
            FrsActivity.F = 0L;
            FrsActivity.G = 0L;
            FrsActivity.H = 0;
        } else {
            FrsActivity.H = 1;
        }
        cvVar2 = this.a.B;
        cvVar2.b(false);
        switch (i) {
            case 1:
                cvVar5 = this.a.B;
                cvVar5.c(false);
                cvVar6 = this.a.B;
                cvVar6.z();
                break;
            case 2:
                cvVar3 = this.a.B;
                cvVar3.d(false);
                cvVar4 = this.a.B;
                cvVar4.z();
                break;
        }
        if (!z && (jVar == null || jVar.c == 0)) {
            gVar10 = this.a.N;
            if (gVar10 != null) {
                gVar37 = this.a.N;
                if (gVar37.n().a() == 1) {
                    this.a.T = "frs_page";
                } else {
                    this.a.T = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                gVar38 = this.a.N;
                frsActivity.q = gVar38.i().getName();
                FrsActivity frsActivity2 = this.a;
                gVar39 = this.a.N;
                frsActivity2.z = gVar39.i().getId();
                z5 = this.a.J;
                if (z5) {
                    this.a.T = "good_page";
                }
                cvVar25 = this.a.B;
                z6 = this.a.J;
                cvVar25.e(z6);
                cvVar26 = this.a.B;
                gVar40 = this.a.N;
                ForumData i5 = gVar40.i();
                gVar41 = this.a.N;
                cvVar26.a(i5, gVar41.k());
            }
            z2 = this.a.ai;
            if (z2) {
                FrsActivity frsActivity3 = this.a;
                gVar34 = this.a.N;
                frsActivity3.b(gVar34);
                FrsActivity frsActivity4 = this.a;
                gVar35 = this.a.N;
                frsActivity4.e(gVar35);
                FrsActivity frsActivity5 = this.a;
                gVar36 = this.a.N;
                frsActivity5.c(gVar36);
            }
            z3 = this.a.L;
            if (z3) {
                LimitList hasShowAppForums = TbadkApplication.m252getInst().getHasShowAppForums();
                str4 = this.a.q;
                if (!hasShowAppForums.contains(str4)) {
                    this.a.L = false;
                    LimitList hasShowAppForums2 = TbadkApplication.m252getInst().getHasShowAppForums();
                    str5 = this.a.q;
                    hasShowAppForums2.add(str5);
                    gVar31 = this.a.N;
                    if (gVar31 != null) {
                        gVar32 = this.a.N;
                        if (gVar32.i() != null) {
                            gVar33 = this.a.N;
                            com.baidu.tbadk.core.data.d bannerListData = gVar33.i().getBannerListData();
                            if (bannerListData != null && bannerListData.a() != null) {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 < bannerListData.a().size()) {
                                        FrsActivity frsActivity6 = this.a;
                                        str7 = frsActivity6.aa;
                                        frsActivity6.aa = String.valueOf(str7) + bannerListData.a().get(i7).g;
                                        if (i7 < bannerListData.a().size() - 1) {
                                            FrsActivity frsActivity7 = this.a;
                                            str8 = frsActivity7.aa;
                                            frsActivity7.aa = String.valueOf(str8) + "|";
                                        }
                                        i6 = i7 + 1;
                                    } else {
                                        FrsActivity frsActivity8 = this.a;
                                        str6 = this.a.aa;
                                        TiebaStatic.eventStat(frsActivity8, "frs_show_app", "frs_recommend_app", 1, "app_name", str6);
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
            gVar11 = this.a.N;
            com.baidu.tbadk.core.data.o top_notice_data = gVar11.i().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                nVar.c(top_notice_data.a());
                nVar.b(2);
                nVar.b(top_notice_data.b());
                nVar.D();
                gVar28 = this.a.N;
                gVar28.a(nVar);
                cvVar23 = this.a.B;
                if (cvVar23.v() != null) {
                    gVar29 = this.a.N;
                    ArrayList<LiveCardData> c = gVar29.c();
                    if (c != null && c.size() > 0) {
                        cvVar24 = this.a.B;
                        bd v = cvVar24.v();
                        FrsActivity frsActivity9 = this.a;
                        gVar30 = this.a.N;
                        d = frsActivity9.d(gVar30);
                        v.a(d);
                    }
                }
            }
            z4 = this.a.K;
            if (z4) {
                cvVar20 = this.a.B;
                cvVar20.H();
                cvVar21 = this.a.B;
                bd v2 = cvVar21.v();
                onClickListener = this.a.aC;
                v2.a(onClickListener);
                cvVar22 = this.a.B;
                bd v3 = cvVar22.v();
                onClickListener2 = this.a.aD;
                v3.b(onClickListener2);
                this.a.K = false;
            }
            str = this.a.T;
            if (str.equals("frs_page")) {
                cvVar19 = this.a.B;
                gVar26 = this.a.N;
                int isMem = gVar26.k().getIsMem();
                gVar27 = this.a.N;
                cvVar19.b(isMem, gVar27.i().isLike());
            } else {
                str2 = this.a.T;
                if (str2.equals("normal_page")) {
                    cvVar8 = this.a.B;
                    gVar13 = this.a.N;
                    int isMem2 = gVar13.k().getIsMem();
                    gVar14 = this.a.N;
                    cvVar8.a(isMem2, gVar14.i().isLike());
                } else {
                    str3 = this.a.T;
                    if (str3.equals("good_page")) {
                        cvVar7 = this.a.B;
                        gVar12 = this.a.N;
                        ArrayList<com.baidu.tbadk.core.data.h> good_classify = gVar12.i().getGood_classify();
                        onItemClickListener = this.a.aE;
                        cvVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.F = (System.nanoTime() - this.b) / 1000000;
            if (jVar != null) {
                FrsActivity.G = jVar.e;
            }
            gVar15 = this.a.N;
            if (gVar15 != null) {
                gVar20 = this.a.N;
                if (gVar20.j() != null) {
                    gVar21 = this.a.N;
                    if (gVar21.j().size() == 0) {
                        i2 = this.a.p;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(com.baidu.tieba.x.no_more_to_load));
                            i3 = this.a.t;
                            if (i3 > 1) {
                                FrsActivity frsActivity10 = this.a;
                                i4 = frsActivity10.t;
                                frsActivity10.t = i4 - 1;
                            }
                            j4 = this.a.Z;
                            if (j4 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j5 = this.a.Z;
                                gVar22 = this.a.N;
                                long g = gVar22.g();
                                j6 = this.a.Z;
                                long j7 = g - j6;
                                gVar23 = this.a.N;
                                long e = gVar23.e();
                                gVar24 = this.a.N;
                                long f = gVar24.f();
                                gVar25 = this.a.N;
                                TiebaStatic.page("op_frs_enter", currentTimeMillis - j5, j7, e, f, currentTimeMillis - gVar25.d());
                                this.a.Z = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            gVar16 = this.a.N;
            if (gVar16 != null) {
                gVar18 = this.a.N;
                if (gVar18.k() != null) {
                    gVar19 = this.a.N;
                    if (gVar19.k().isBawu()) {
                        cvVar18 = this.a.B;
                        cvVar18.g(true);
                        this.a.G();
                        gVar17 = this.a.N;
                        if (!gVar17.h()) {
                            cvVar14 = this.a.B;
                            if (cvVar14.w() != null) {
                                cvVar17 = this.a.B;
                                cvVar17.w().k();
                            }
                            cvVar15 = this.a.B;
                            if (cvVar15.x() != null) {
                                cvVar16 = this.a.B;
                                cvVar16.x().l();
                            }
                        } else {
                            cvVar10 = this.a.B;
                            if (cvVar10.w() != null) {
                                cvVar13 = this.a.B;
                                cvVar13.w().j();
                            }
                            cvVar11 = this.a.B;
                            if (cvVar11.x() != null) {
                                cvVar12 = this.a.B;
                                cvVar12.x().k();
                            }
                        }
                    }
                }
            }
            cvVar9 = this.a.B;
            cvVar9.g(false);
            this.a.G();
            gVar17 = this.a.N;
            if (!gVar17.h()) {
            }
        } else {
            this.a.a(jVar);
        }
        this.a.C = null;
        j = this.a.Z;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.Z;
            gVar6 = this.a.N;
            long g2 = gVar6.g();
            j3 = this.a.Z;
            long j8 = g2 - j3;
            gVar7 = this.a.N;
            long e2 = gVar7.e();
            gVar8 = this.a.N;
            long f2 = gVar8.f();
            gVar9 = this.a.N;
            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - j2, j8, e2, f2, currentTimeMillis2 - gVar9.d());
            this.a.Z = -1L;
        }
        FrsActivity frsActivity11 = this.a;
        gVar = this.a.N;
        frsActivity11.a(gVar);
        gVar2 = this.a.N;
        this.a.a(Boolean.valueOf(gVar2.l().isIfvoice()));
        gVar3 = this.a.N;
        if (gVar3 != null) {
            gVar4 = this.a.N;
            if (gVar4.k() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                gVar5 = this.a.N;
                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(gVar5.k().getIsMem())));
            }
        }
        System.gc();
    }

    @Override // com.baidu.tieba.frs.dn
    public void a(g gVar) {
        String str;
        String str2;
        if (gVar != null) {
            str = this.a.T;
            if (!str.equals("normal_page")) {
                str2 = this.a.T;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.a.f(gVar);
        }
    }
}
