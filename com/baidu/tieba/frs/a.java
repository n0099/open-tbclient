package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.NetWorkCore;
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
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                azVar3 = this.a.l;
                azVar3.c(true);
                azVar4 = this.a.l;
                azVar4.k();
                return;
            case 2:
                azVar = this.a.l;
                azVar.d(true);
                azVar2 = this.a.l;
                azVar2.k();
                return;
            case 3:
                azVar5 = this.a.l;
                azVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.ac
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.y yVar) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        com.baidu.tieba.model.v vVar;
        boolean z;
        String str;
        String str2;
        String str3;
        az azVar6;
        com.baidu.tieba.model.v vVar2;
        AdapterView.OnItemClickListener onItemClickListener;
        az azVar7;
        com.baidu.tieba.model.v vVar3;
        com.baidu.tieba.model.v vVar4;
        com.baidu.tieba.model.v vVar5;
        int i2;
        int i3;
        int i4;
        az azVar8;
        az azVar9;
        com.baidu.tieba.model.v vVar6;
        com.baidu.tieba.model.v vVar7;
        boolean z2;
        az azVar10;
        if (yVar == null || !yVar.b) {
            FrsActivity.r = 1;
        } else {
            boolean z3 = NetWorkCore.c(this.a) == NetWorkCore.NetworkStateInfo.WIFI;
            azVar10 = this.a.l;
            azVar10.g().b(z3);
            FrsActivity.p = 0L;
            FrsActivity.q = 0L;
            FrsActivity.r = 0;
        }
        azVar = this.a.l;
        azVar.b(false);
        switch (i) {
            case 1:
                azVar4 = this.a.l;
                azVar4.c(false);
                azVar5 = this.a.l;
                azVar5.k();
                break;
            case 2:
                azVar2 = this.a.l;
                azVar2.d(false);
                azVar3 = this.a.l;
                azVar3.k();
                break;
        }
        if (jSONObject != null && (yVar == null || yVar.c == 0)) {
            vVar = this.a.v;
            if (vVar != null) {
                vVar6 = this.a.v;
                if (vVar6.e().a() == 1) {
                    this.a.A = "frs_page";
                } else {
                    this.a.A = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                vVar7 = this.a.v;
                frsActivity.c = vVar7.a().b();
                z2 = this.a.t;
                if (z2) {
                    this.a.A = "good_page";
                }
            }
            z = this.a.u;
            if (z) {
                azVar9 = this.a.l;
                azVar9.q();
                this.a.u = false;
            }
            str = this.a.A;
            if (str == "frs_page") {
                azVar8 = this.a.l;
                azVar8.m();
            } else {
                str2 = this.a.A;
                if (str2 == "normal_page") {
                    azVar7 = this.a.l;
                    azVar7.l();
                } else {
                    str3 = this.a.A;
                    if (str3 == "good_page") {
                        azVar6 = this.a.l;
                        vVar2 = this.a.v;
                        ArrayList h = vVar2.a().h();
                        onItemClickListener = this.a.V;
                        azVar6.a(h, onItemClickListener);
                    }
                }
            }
            FrsActivity.p = (System.nanoTime() - this.b) / 1000000;
            if (yVar != null) {
                FrsActivity.q = yVar.e;
            }
            vVar3 = this.a.v;
            if (vVar3 != null) {
                vVar4 = this.a.v;
                if (vVar4.b() != null) {
                    vVar5 = this.a.v;
                    if (vVar5.b().size() == 0) {
                        i2 = this.a.b;
                        if (i2 == 1) {
                            this.a.a(this.a.getString(R.string.no_more_to_load));
                            i3 = this.a.f;
                            if (i3 > 1) {
                                FrsActivity frsActivity2 = this.a;
                                i4 = frsActivity2.f;
                                frsActivity2.f = i4 - 1;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.a.B();
        } else {
            this.a.a(yVar);
        }
        this.a.m = null;
        System.gc();
    }
}
