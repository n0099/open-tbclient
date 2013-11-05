package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1246a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.f1246a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ac
    public void a(int i) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                baVar3 = this.f1246a.o;
                baVar3.d(true);
                baVar4 = this.f1246a.o;
                baVar4.l();
                return;
            case 2:
                baVar = this.f1246a.o;
                baVar.e(true);
                baVar2 = this.f1246a.o;
                baVar2.l();
                return;
            case 3:
                baVar5 = this.f1246a.o;
                baVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.ac
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.an anVar) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        ba baVar6;
        com.baidu.tieba.model.ak akVar;
        boolean z;
        String str;
        String str2;
        String str3;
        ba baVar7;
        com.baidu.tieba.model.ak akVar2;
        AdapterView.OnItemClickListener onItemClickListener;
        ba baVar8;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        int i2;
        int i3;
        ba baVar9;
        ba baVar10;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        boolean z2;
        ba baVar11;
        ba baVar12;
        if (UtilHelper.i(this.f1246a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            baVar12 = this.f1246a.o;
            baVar12.c();
        } else {
            baVar = this.f1246a.o;
            baVar.d();
        }
        if (anVar == null || !anVar.b) {
            int unused = FrsActivity.t = 1;
        } else {
            baVar11 = this.f1246a.o;
            baVar11.h().b(com.baidu.tieba.util.bd.a().b());
            long unused2 = FrsActivity.r = 0L;
            long unused3 = FrsActivity.s = 0L;
            int unused4 = FrsActivity.t = 0;
        }
        baVar2 = this.f1246a.o;
        baVar2.b(false);
        switch (i) {
            case 1:
                baVar5 = this.f1246a.o;
                baVar5.d(false);
                baVar6 = this.f1246a.o;
                baVar6.l();
                break;
            case 2:
                baVar3 = this.f1246a.o;
                baVar3.e(false);
                baVar4 = this.f1246a.o;
                baVar4.l();
                break;
        }
        if (jSONObject == null || (anVar != null && anVar.c != 0)) {
            this.f1246a.a(anVar);
        } else {
            akVar = this.f1246a.x;
            if (akVar != null) {
                akVar6 = this.f1246a.x;
                if (akVar6.e().a() == 1) {
                    this.f1246a.C = "frs_page";
                } else {
                    this.f1246a.C = "normal_page";
                }
                FrsActivity frsActivity = this.f1246a;
                akVar7 = this.f1246a.x;
                frsActivity.e = akVar7.a().getName();
                z2 = this.f1246a.v;
                if (z2) {
                    this.f1246a.C = "good_page";
                }
            }
            z = this.f1246a.w;
            if (z) {
                baVar10 = this.f1246a.o;
                baVar10.r();
                this.f1246a.w = false;
            }
            str = this.f1246a.C;
            if (str.equals("frs_page")) {
                baVar9 = this.f1246a.o;
                baVar9.n();
            } else {
                str2 = this.f1246a.C;
                if (str2.equals("normal_page")) {
                    baVar8 = this.f1246a.o;
                    baVar8.m();
                } else {
                    str3 = this.f1246a.C;
                    if (str3.equals("good_page")) {
                        baVar7 = this.f1246a.o;
                        akVar2 = this.f1246a.x;
                        ArrayList<com.baidu.tieba.data.aa> good_classify = akVar2.a().getGood_classify();
                        onItemClickListener = this.f1246a.X;
                        baVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            long unused5 = FrsActivity.r = (System.nanoTime() - this.b) / 1000000;
            if (anVar != null) {
                long unused6 = FrsActivity.s = anVar.e;
            }
            akVar3 = this.f1246a.x;
            if (akVar3 != null) {
                akVar4 = this.f1246a.x;
                if (akVar4.b() != null) {
                    akVar5 = this.f1246a.x;
                    if (akVar5.b().size() == 0) {
                        i2 = this.f1246a.d;
                        if (i2 == 1) {
                            this.f1246a.a(this.f1246a.getString(R.string.no_more_to_load));
                            i3 = this.f1246a.j;
                            if (i3 > 1) {
                                FrsActivity.i(this.f1246a);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.f1246a.F();
        }
        this.f1246a.p = null;
        System.gc();
    }

    @Override // com.baidu.tieba.frs.ac
    public void a(com.baidu.tieba.model.ak akVar) {
        String str;
        String str2;
        if (akVar != null) {
            str = this.f1246a.C;
            if (!str.equals("normal_page")) {
                str2 = this.f1246a.C;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.f1246a.a(akVar);
        }
    }
}
