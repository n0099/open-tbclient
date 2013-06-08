package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a implements ac {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.a = frsActivity;
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
                baVar3 = this.a.l;
                baVar3.c(true);
                baVar4 = this.a.l;
                baVar4.k();
                return;
            case 2:
                baVar = this.a.l;
                baVar.d(true);
                baVar2 = this.a.l;
                baVar2.k();
                return;
            case 3:
                baVar5 = this.a.l;
                baVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.ac
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.c.v vVar) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        com.baidu.tieba.c.s sVar;
        boolean z;
        String str;
        String str2;
        String str3;
        ba baVar6;
        com.baidu.tieba.c.s sVar2;
        AdapterView.OnItemClickListener onItemClickListener;
        ba baVar7;
        com.baidu.tieba.c.s sVar3;
        com.baidu.tieba.c.s sVar4;
        com.baidu.tieba.c.s sVar5;
        int i2;
        int i3;
        int i4;
        ba baVar8;
        ba baVar9;
        com.baidu.tieba.c.s sVar6;
        com.baidu.tieba.c.s sVar7;
        boolean z2;
        ba baVar10;
        if (vVar == null || !vVar.b) {
            FrsActivity.r = 1;
        } else {
            boolean z3 = com.baidu.tieba.d.w.c(this.a) == com.baidu.tieba.d.z.WIFI;
            baVar10 = this.a.l;
            baVar10.g().b(z3);
            FrsActivity.p = 0L;
            FrsActivity.q = 0L;
            FrsActivity.r = 0;
        }
        baVar = this.a.l;
        baVar.b(false);
        switch (i) {
            case 1:
                baVar4 = this.a.l;
                baVar4.c(false);
                baVar5 = this.a.l;
                baVar5.k();
                break;
            case 2:
                baVar2 = this.a.l;
                baVar2.d(false);
                baVar3 = this.a.l;
                baVar3.k();
                break;
        }
        if (jSONObject != null && (vVar == null || vVar.c == 0)) {
            sVar = this.a.v;
            if (sVar != null) {
                sVar6 = this.a.v;
                if (sVar6.e().a() == 1) {
                    this.a.A = "frs_page";
                } else {
                    this.a.A = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                sVar7 = this.a.v;
                frsActivity.e = sVar7.a().b();
                z2 = this.a.t;
                if (z2) {
                    this.a.A = "good_page";
                }
            }
            z = this.a.u;
            if (z) {
                baVar9 = this.a.l;
                baVar9.q();
                this.a.u = false;
            }
            str = this.a.A;
            if (str == "frs_page") {
                baVar8 = this.a.l;
                baVar8.m();
            } else {
                str2 = this.a.A;
                if (str2 == "normal_page") {
                    baVar7 = this.a.l;
                    baVar7.l();
                } else {
                    str3 = this.a.A;
                    if (str3 == "good_page") {
                        baVar6 = this.a.l;
                        sVar2 = this.a.v;
                        ArrayList h = sVar2.a().h();
                        onItemClickListener = this.a.V;
                        baVar6.a(h, onItemClickListener);
                    }
                }
            }
            FrsActivity.p = (System.nanoTime() - this.b) / 1000000;
            if (vVar != null) {
                FrsActivity.q = vVar.e;
            }
            sVar3 = this.a.v;
            if (sVar3 != null) {
                sVar4 = this.a.v;
                if (sVar4.b() != null) {
                    sVar5 = this.a.v;
                    if (sVar5.b().size() == 0) {
                        i2 = this.a.d;
                        if (i2 == 1) {
                            this.a.a(this.a.getString(R.string.no_more_to_load));
                            i3 = this.a.h;
                            if (i3 > 1) {
                                FrsActivity frsActivity2 = this.a;
                                i4 = frsActivity2.h;
                                frsActivity2.h = i4 - 1;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.a.B();
        } else {
            this.a.a(vVar);
        }
        this.a.m = null;
        System.gc();
    }
}
