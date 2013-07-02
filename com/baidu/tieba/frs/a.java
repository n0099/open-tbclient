package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.R;
import com.baidu.tieba.util.NetWorkCore;
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
                azVar3 = this.a.m;
                azVar3.c(true);
                azVar4 = this.a.m;
                azVar4.k();
                return;
            case 2:
                azVar = this.a.m;
                azVar.d(true);
                azVar2 = this.a.m;
                azVar2.k();
                return;
            case 3:
                azVar5 = this.a.m;
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
        boolean z;
        String str;
        String str2;
        String str3;
        az azVar6;
        AdapterView.OnItemClickListener onItemClickListener;
        az azVar7;
        int i2;
        int i3;
        int i4;
        az azVar8;
        az azVar9;
        boolean z2;
        az azVar10;
        if (yVar == null || !yVar.b) {
            FrsActivity.s = 1;
        } else {
            boolean z3 = NetWorkCore.c(this.a) == NetWorkCore.NetworkStateInfo.WIFI;
            azVar10 = this.a.m;
            azVar10.g().b(z3);
            FrsActivity.q = 0L;
            FrsActivity.r = 0L;
            FrsActivity.s = 0;
        }
        azVar = this.a.m;
        azVar.b(false);
        switch (i) {
            case 1:
                azVar4 = this.a.m;
                azVar4.c(false);
                azVar5 = this.a.m;
                azVar5.k();
                break;
            case 2:
                azVar2 = this.a.m;
                azVar2.d(false);
                azVar3 = this.a.m;
                azVar3.k();
                break;
        }
        if (jSONObject != null && (yVar == null || yVar.c == 0)) {
            if (this.a.a != null) {
                if (this.a.a.e().a() == 1) {
                    this.a.A = "frs_page";
                } else {
                    this.a.A = "normal_page";
                }
                this.a.d = this.a.a.a().b();
                z2 = this.a.u;
                if (z2) {
                    this.a.A = "good_page";
                }
            }
            z = this.a.v;
            if (z) {
                azVar9 = this.a.m;
                azVar9.q();
                this.a.v = false;
            }
            str = this.a.A;
            if (str == "frs_page") {
                azVar8 = this.a.m;
                azVar8.m();
            } else {
                str2 = this.a.A;
                if (str2 == "normal_page") {
                    azVar7 = this.a.m;
                    azVar7.l();
                } else {
                    str3 = this.a.A;
                    if (str3 == "good_page") {
                        azVar6 = this.a.m;
                        ArrayList i5 = this.a.a.a().i();
                        onItemClickListener = this.a.V;
                        azVar6.a(i5, onItemClickListener);
                    }
                }
            }
            FrsActivity.q = (System.nanoTime() - this.b) / 1000000;
            if (yVar != null) {
                FrsActivity.r = yVar.e;
            }
            if (this.a.a != null && this.a.a.b() != null && this.a.a.b().size() == 0) {
                i2 = this.a.c;
                if (i2 == 1) {
                    this.a.a(this.a.getString(R.string.no_more_to_load));
                    i3 = this.a.g;
                    if (i3 > 1) {
                        FrsActivity frsActivity = this.a;
                        i4 = frsActivity.g;
                        frsActivity.g = i4 - 1;
                        return;
                    }
                    return;
                }
            }
            this.a.B();
        } else {
            this.a.a(yVar);
        }
        this.a.n = null;
        System.gc();
    }
}
