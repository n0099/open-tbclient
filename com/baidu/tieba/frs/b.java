package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bx;
import com.baidu.tieba.util.by;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ab {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ab
    public void a(int i) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        com.baidu.tieba.model.ak akVar;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                bkVar3 = this.a.n;
                bkVar3.c(true);
                bkVar4 = this.a.n;
                bkVar4.r();
                break;
            case 2:
                bkVar = this.a.n;
                bkVar.d(true);
                bkVar2 = this.a.n;
                bkVar2.r();
                break;
            case 3:
                bkVar5 = this.a.n;
                bkVar5.b(true);
                break;
        }
        akVar = this.a.w;
        if (akVar.a()) {
            bkVar8 = this.a.n;
            bkVar8.o().j();
            bkVar9 = this.a.n;
            bkVar9.p().i();
            return;
        }
        bkVar6 = this.a.n;
        bkVar6.o().i();
        bkVar7 = this.a.n;
        bkVar7.p().h();
    }

    @Override // com.baidu.tieba.frs.ab
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.an anVar) {
        bk bkVar;
        long j;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        boolean z;
        String str;
        String str2;
        String str3;
        bk bkVar7;
        com.baidu.tieba.model.ak akVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        bk bkVar8;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        bk bkVar9;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        bk bkVar10;
        com.baidu.tieba.model.ak akVar8;
        com.baidu.tieba.model.ak akVar9;
        int i2;
        int i3;
        bk bkVar11;
        bk bkVar12;
        com.baidu.tieba.model.ak akVar10;
        com.baidu.tieba.model.ak akVar11;
        com.baidu.tieba.model.ak akVar12;
        boolean z2;
        bk bkVar13;
        long j2;
        bk bkVar14;
        if (UtilHelper.g(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bkVar14 = this.a.n;
            bkVar14.h();
        } else {
            bkVar = this.a.n;
            bkVar.i();
        }
        j = this.a.L;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.L;
            by.a(currentTimeMillis - j2);
            this.a.L = -1L;
        }
        if (anVar == null || !anVar.b) {
            int unused = FrsActivity.s = 1;
        } else {
            bkVar13 = this.a.n;
            bkVar13.n().a(bx.a().b());
            long unused2 = FrsActivity.q = 0L;
            long unused3 = FrsActivity.r = 0L;
            int unused4 = FrsActivity.s = 0;
        }
        bkVar2 = this.a.n;
        bkVar2.b(false);
        switch (i) {
            case 1:
                bkVar5 = this.a.n;
                bkVar5.c(false);
                bkVar6 = this.a.n;
                bkVar6.r();
                break;
            case 2:
                bkVar3 = this.a.n;
                bkVar3.d(false);
                bkVar4 = this.a.n;
                bkVar4.r();
                break;
        }
        if (jSONObject == null || (anVar != null && anVar.c != 0)) {
            this.a.a(anVar);
        } else {
            akVar = this.a.w;
            if (akVar != null) {
                akVar11 = this.a.w;
                if (akVar11.g().a() == 1) {
                    this.a.C = "frs_page";
                } else {
                    this.a.C = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                akVar12 = this.a.w;
                frsActivity.f = akVar12.b().getName();
                z2 = this.a.u;
                if (z2) {
                    this.a.C = "good_page";
                }
            }
            akVar2 = this.a.w;
            com.baidu.tieba.data.bd top_notice_data = akVar2.b().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tieba.data.bb bbVar = new com.baidu.tieba.data.bb();
                bbVar.c(top_notice_data.a());
                bbVar.a(2);
                bbVar.b(top_notice_data.b());
                bbVar.t();
                akVar10 = this.a.w;
                akVar10.c().add(0, bbVar);
            }
            z = this.a.v;
            if (z) {
                bkVar12 = this.a.n;
                bkVar12.B();
                this.a.v = false;
            }
            str = this.a.C;
            if (str.equals("frs_page")) {
                bkVar11 = this.a.n;
                bkVar11.t();
            } else {
                str2 = this.a.C;
                if (str2.equals("normal_page")) {
                    bkVar8 = this.a.n;
                    bkVar8.s();
                } else {
                    str3 = this.a.C;
                    if (str3.equals("good_page")) {
                        bkVar7 = this.a.n;
                        akVar3 = this.a.w;
                        ArrayList<com.baidu.tieba.data.aa> good_classify = akVar3.b().getGood_classify();
                        onItemClickListener = this.a.ad;
                        bkVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            long unused5 = FrsActivity.q = (System.nanoTime() - this.b) / 1000000;
            if (anVar != null) {
                long unused6 = FrsActivity.r = anVar.e;
            }
            akVar4 = this.a.w;
            if (akVar4 != null) {
                akVar8 = this.a.w;
                if (akVar8.c() != null) {
                    akVar9 = this.a.w;
                    if (akVar9.c().size() == 0) {
                        i2 = this.a.e;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(R.string.no_more_to_load));
                            i3 = this.a.i;
                            if (i3 > 1) {
                                FrsActivity.j(this.a);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            akVar5 = this.a.w;
            if (akVar5 != null) {
                akVar6 = this.a.w;
                if (akVar6.d() != null) {
                    akVar7 = this.a.w;
                    if (akVar7.d().getIsManager()) {
                        bkVar10 = this.a.n;
                        bkVar10.f(true);
                        this.a.C();
                    }
                }
            }
            bkVar9 = this.a.n;
            bkVar9.f(false);
            this.a.C();
        }
        this.a.o = null;
        System.gc();
    }

    @Override // com.baidu.tieba.frs.ab
    public void a(com.baidu.tieba.model.ak akVar) {
        String str;
        String str2;
        if (akVar != null) {
            str = this.a.C;
            if (!str.equals("normal_page")) {
                str2 = this.a.C;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.a.a(akVar);
        }
    }
}
