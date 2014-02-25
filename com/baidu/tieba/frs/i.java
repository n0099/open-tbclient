package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.util.LimitList;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class i implements by {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.by
    public void a(int i) {
        br brVar;
        br brVar2;
        br brVar3;
        br brVar4;
        br brVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                brVar3 = this.a.p;
                brVar3.c(true);
                brVar4 = this.a.p;
                brVar4.r();
                return;
            case 2:
                brVar = this.a.p;
                brVar.d(true);
                brVar2 = this.a.p;
                brVar2.r();
                return;
            case 3:
                brVar5 = this.a.p;
                brVar5.b(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x035f  */
    @Override // com.baidu.tieba.frs.by
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ac acVar) {
        br brVar;
        br brVar2;
        br brVar3;
        br brVar4;
        br brVar5;
        br brVar6;
        long j;
        long j2;
        com.baidu.tieba.model.z zVar;
        boolean z;
        com.baidu.tieba.model.z zVar2;
        boolean z2;
        String str;
        String str2;
        String str3;
        br brVar7;
        com.baidu.tieba.model.z zVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        br brVar8;
        com.baidu.tieba.model.z zVar4;
        com.baidu.tieba.model.z zVar5;
        br brVar9;
        com.baidu.tieba.model.z zVar6;
        br brVar10;
        br brVar11;
        br brVar12;
        br brVar13;
        com.baidu.tieba.model.z zVar7;
        com.baidu.tieba.model.z zVar8;
        br brVar14;
        com.baidu.tieba.model.z zVar9;
        com.baidu.tieba.model.z zVar10;
        int i2;
        int i3;
        long j3;
        long j4;
        int i4;
        br brVar15;
        br brVar16;
        com.baidu.tieba.model.z zVar11;
        String str4;
        com.baidu.tieba.model.z zVar12;
        String str5;
        com.baidu.tieba.model.z zVar13;
        com.baidu.tieba.model.z zVar14;
        com.baidu.tieba.model.z zVar15;
        String str6;
        String str7;
        String str8;
        com.baidu.tieba.model.z zVar16;
        com.baidu.tieba.model.z zVar17;
        boolean z3;
        br brVar17;
        com.baidu.tieba.model.z zVar18;
        br brVar18;
        br brVar19;
        if (UtilHelper.h(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            brVar19 = this.a.p;
            brVar19.h();
        } else {
            brVar = this.a.p;
            brVar.i();
        }
        if (acVar != null && acVar.b) {
            brVar18 = this.a.p;
            brVar18.n().a(com.baidu.tieba.util.bv.a().b());
            FrsActivity.s = 0L;
            FrsActivity.t = 0L;
            FrsActivity.u = 0;
        } else {
            FrsActivity.u = 1;
        }
        brVar2 = this.a.p;
        brVar2.b(false);
        switch (i) {
            case 1:
                brVar5 = this.a.p;
                brVar5.c(false);
                brVar6 = this.a.p;
                brVar6.r();
                break;
            case 2:
                brVar3 = this.a.p;
                brVar3.d(false);
                brVar4 = this.a.p;
                brVar4.r();
                break;
        }
        if (jSONObject != null && (acVar == null || acVar.c == 0)) {
            zVar = this.a.A;
            if (zVar != null) {
                zVar16 = this.a.A;
                if (zVar16.g().a() == 1) {
                    this.a.G = "frs_page";
                } else {
                    this.a.G = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                zVar17 = this.a.A;
                frsActivity.g = zVar17.b().getName();
                z3 = this.a.w;
                if (z3) {
                    this.a.G = "good_page";
                }
                brVar17 = this.a.p;
                zVar18 = this.a.A;
                brVar17.a(zVar18.b());
            }
            z = this.a.y;
            if (z) {
                LimitList br = TiebaApplication.g().br();
                str4 = this.a.g;
                if (!br.contains(str4)) {
                    FrsActivity frsActivity2 = this.a;
                    zVar12 = this.a.A;
                    frsActivity2.a(zVar12);
                    this.a.y = false;
                    LimitList br2 = TiebaApplication.g().br();
                    str5 = this.a.g;
                    br2.add(str5);
                    zVar13 = this.a.A;
                    if (zVar13 != null) {
                        zVar14 = this.a.A;
                        if (zVar14.b() != null) {
                            zVar15 = this.a.A;
                            h bannerListData = zVar15.b().getBannerListData();
                            if (bannerListData != null && bannerListData.a() != null) {
                                for (int i5 = 0; i5 < bannerListData.a().size(); i5++) {
                                    FrsActivity frsActivity3 = this.a;
                                    str7 = frsActivity3.R;
                                    frsActivity3.R = String.valueOf(str7) + bannerListData.a().get(i5).y();
                                    if (i5 < bannerListData.a().size() - 1) {
                                        FrsActivity frsActivity4 = this.a;
                                        str8 = frsActivity4.R;
                                        frsActivity4.R = String.valueOf(str8) + "|";
                                    }
                                }
                                FrsActivity frsActivity5 = this.a;
                                str6 = this.a.R;
                                cb.a(frsActivity5, "frs_show_app", "frs_recommend_app", 1, "app_name", str6);
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            zVar2 = this.a.A;
            com.baidu.tieba.data.bb top_notice_data = zVar2.b().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                azVar.c(top_notice_data.a());
                azVar.a(2);
                azVar.b(top_notice_data.b());
                azVar.t();
                zVar11 = this.a.A;
                zVar11.c().add(0, azVar);
            }
            z2 = this.a.x;
            if (z2) {
                brVar16 = this.a.p;
                brVar16.B();
                this.a.x = false;
            }
            str = this.a.G;
            if (str.equals("frs_page")) {
                brVar15 = this.a.p;
                brVar15.t();
            } else {
                str2 = this.a.G;
                if (str2.equals("normal_page")) {
                    brVar8 = this.a.p;
                    brVar8.s();
                } else {
                    str3 = this.a.G;
                    if (str3.equals("good_page")) {
                        brVar7 = this.a.p;
                        zVar3 = this.a.A;
                        ArrayList<com.baidu.tieba.data.z> good_classify = zVar3.b().getGood_classify();
                        onItemClickListener = this.a.aj;
                        brVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            FrsActivity.s = (System.nanoTime() - this.b) / 1000000;
            if (acVar != null) {
                FrsActivity.t = acVar.e;
            }
            zVar4 = this.a.A;
            if (zVar4 != null) {
                zVar9 = this.a.A;
                if (zVar9.c() != null) {
                    zVar10 = this.a.A;
                    if (zVar10.c().size() == 0) {
                        i2 = this.a.f;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(R.string.no_more_to_load));
                            i3 = this.a.j;
                            if (i3 > 1) {
                                FrsActivity frsActivity6 = this.a;
                                i4 = frsActivity6.j;
                                frsActivity6.j = i4 - 1;
                            }
                            j3 = this.a.P;
                            if (j3 > -1) {
                                long currentTimeMillis = System.currentTimeMillis();
                                j4 = this.a.P;
                                cb.a("op_frs_enter", currentTimeMillis - j4);
                                this.a.P = -1L;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            zVar5 = this.a.A;
            if (zVar5 != null) {
                zVar7 = this.a.A;
                if (zVar7.d() != null) {
                    zVar8 = this.a.A;
                    if (zVar8.d().getIsManager()) {
                        brVar14 = this.a.p;
                        brVar14.f(true);
                        this.a.F();
                        zVar6 = this.a.A;
                        if (!zVar6.a()) {
                            brVar12 = this.a.p;
                            brVar12.o().j();
                            brVar13 = this.a.p;
                            brVar13.p().i();
                        } else {
                            brVar10 = this.a.p;
                            brVar10.o().i();
                            brVar11 = this.a.p;
                            brVar11.p().h();
                        }
                    }
                }
            }
            brVar9 = this.a.p;
            brVar9.f(false);
            this.a.F();
            zVar6 = this.a.A;
            if (!zVar6.a()) {
            }
        } else {
            this.a.a(acVar);
        }
        this.a.q = null;
        j = this.a.P;
        if (j > -1) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j2 = this.a.P;
            cb.a("op_frs_enter", currentTimeMillis2 - j2);
            this.a.P = -1L;
        }
        System.gc();
    }

    @Override // com.baidu.tieba.frs.by
    public void a(com.baidu.tieba.model.z zVar) {
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
            this.a.b(zVar);
        }
    }
}
