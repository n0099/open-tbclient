package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.NetWorkCore;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f828a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.f828a = frsActivity;
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
                azVar3 = this.f828a.l;
                azVar3.c(true);
                azVar4 = this.f828a.l;
                azVar4.k();
                return;
            case 2:
                azVar = this.f828a.l;
                azVar.d(true);
                azVar2 = this.f828a.l;
                azVar2.k();
                return;
            case 3:
                azVar5 = this.f828a.l;
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
            boolean z3 = NetWorkCore.c(this.f828a) == NetWorkCore.NetworkStateInfo.WIFI;
            azVar10 = this.f828a.l;
            azVar10.g().b(z3);
            FrsActivity.p = 0L;
            FrsActivity.q = 0L;
            FrsActivity.r = 0;
        }
        azVar = this.f828a.l;
        azVar.b(false);
        switch (i) {
            case 1:
                azVar4 = this.f828a.l;
                azVar4.c(false);
                azVar5 = this.f828a.l;
                azVar5.k();
                break;
            case 2:
                azVar2 = this.f828a.l;
                azVar2.d(false);
                azVar3 = this.f828a.l;
                azVar3.k();
                break;
        }
        if (jSONObject != null && (yVar == null || yVar.c == 0)) {
            vVar = this.f828a.v;
            if (vVar != null) {
                vVar6 = this.f828a.v;
                if (vVar6.e().a() == 1) {
                    this.f828a.A = "frs_page";
                } else {
                    this.f828a.A = "normal_page";
                }
                FrsActivity frsActivity = this.f828a;
                vVar7 = this.f828a.v;
                frsActivity.c = vVar7.a().b();
                z2 = this.f828a.t;
                if (z2) {
                    this.f828a.A = "good_page";
                }
            }
            z = this.f828a.u;
            if (z) {
                azVar9 = this.f828a.l;
                azVar9.q();
                this.f828a.u = false;
            }
            str = this.f828a.A;
            if (str == "frs_page") {
                azVar8 = this.f828a.l;
                azVar8.m();
            } else {
                str2 = this.f828a.A;
                if (str2 == "normal_page") {
                    azVar7 = this.f828a.l;
                    azVar7.l();
                } else {
                    str3 = this.f828a.A;
                    if (str3 == "good_page") {
                        azVar6 = this.f828a.l;
                        vVar2 = this.f828a.v;
                        ArrayList h = vVar2.a().h();
                        onItemClickListener = this.f828a.V;
                        azVar6.a(h, onItemClickListener);
                    }
                }
            }
            FrsActivity.p = (System.nanoTime() - this.b) / 1000000;
            if (yVar != null) {
                FrsActivity.q = yVar.e;
            }
            vVar3 = this.f828a.v;
            if (vVar3 != null) {
                vVar4 = this.f828a.v;
                if (vVar4.b() != null) {
                    vVar5 = this.f828a.v;
                    if (vVar5.b().size() == 0) {
                        i2 = this.f828a.b;
                        if (i2 == 1) {
                            this.f828a.a(this.f828a.getString(R.string.no_more_to_load));
                            i3 = this.f828a.f;
                            if (i3 > 1) {
                                FrsActivity frsActivity2 = this.f828a;
                                i4 = frsActivity2.f;
                                frsActivity2.f = i4 - 1;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.f828a.B();
        } else {
            this.f828a.a(yVar);
        }
        this.f828a.m = null;
        System.gc();
    }
}
