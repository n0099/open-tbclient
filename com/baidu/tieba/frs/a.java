package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1052a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.f1052a = frsActivity;
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
                azVar3 = this.f1052a.l;
                azVar3.d(true);
                azVar4 = this.f1052a.l;
                azVar4.k();
                return;
            case 2:
                azVar = this.f1052a.l;
                azVar.e(true);
                azVar2 = this.f1052a.l;
                azVar2.k();
                return;
            case 3:
                azVar5 = this.f1052a.l;
                azVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.ac
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ad adVar) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        com.baidu.tieba.model.aa aaVar;
        boolean z;
        String str;
        String str2;
        String str3;
        az azVar6;
        com.baidu.tieba.model.aa aaVar2;
        AdapterView.OnItemClickListener onItemClickListener;
        az azVar7;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.model.aa aaVar5;
        int i2;
        int i3;
        int i4;
        az azVar8;
        az azVar9;
        com.baidu.tieba.model.aa aaVar6;
        com.baidu.tieba.model.aa aaVar7;
        boolean z2;
        az azVar10;
        if (adVar != null && adVar.b) {
            azVar10 = this.f1052a.l;
            azVar10.g().b(TiebaApplication.f().bl());
            FrsActivity.p = 0L;
            FrsActivity.q = 0L;
            FrsActivity.r = 0;
        } else {
            FrsActivity.r = 1;
        }
        azVar = this.f1052a.l;
        azVar.b(false);
        switch (i) {
            case 1:
                azVar4 = this.f1052a.l;
                azVar4.d(false);
                azVar5 = this.f1052a.l;
                azVar5.k();
                break;
            case 2:
                azVar2 = this.f1052a.l;
                azVar2.e(false);
                azVar3 = this.f1052a.l;
                azVar3.k();
                break;
        }
        if (jSONObject != null && (adVar == null || adVar.c == 0)) {
            aaVar = this.f1052a.v;
            if (aaVar != null) {
                aaVar6 = this.f1052a.v;
                if (aaVar6.e().a() == 1) {
                    this.f1052a.A = "frs_page";
                } else {
                    this.f1052a.A = "normal_page";
                }
                FrsActivity frsActivity = this.f1052a;
                aaVar7 = this.f1052a.v;
                frsActivity.c = aaVar7.a().b();
                z2 = this.f1052a.t;
                if (z2) {
                    this.f1052a.A = "good_page";
                }
            }
            z = this.f1052a.u;
            if (z) {
                azVar9 = this.f1052a.l;
                azVar9.q();
                this.f1052a.u = false;
            }
            str = this.f1052a.A;
            if (str == "frs_page") {
                azVar8 = this.f1052a.l;
                azVar8.m();
            } else {
                str2 = this.f1052a.A;
                if (str2 == "normal_page") {
                    azVar7 = this.f1052a.l;
                    azVar7.l();
                } else {
                    str3 = this.f1052a.A;
                    if (str3 == "good_page") {
                        azVar6 = this.f1052a.l;
                        aaVar2 = this.f1052a.v;
                        ArrayList j = aaVar2.a().j();
                        onItemClickListener = this.f1052a.V;
                        azVar6.a(j, onItemClickListener);
                    }
                }
            }
            FrsActivity.p = (System.nanoTime() - this.b) / 1000000;
            if (adVar != null) {
                FrsActivity.q = adVar.e;
            }
            aaVar3 = this.f1052a.v;
            if (aaVar3 != null) {
                aaVar4 = this.f1052a.v;
                if (aaVar4.b() != null) {
                    aaVar5 = this.f1052a.v;
                    if (aaVar5.b().size() == 0) {
                        i2 = this.f1052a.b;
                        if (i2 == 1) {
                            this.f1052a.a(this.f1052a.getString(R.string.no_more_to_load));
                            i3 = this.f1052a.f;
                            if (i3 > 1) {
                                FrsActivity frsActivity2 = this.f1052a;
                                i4 = frsActivity2.f;
                                frsActivity2.f = i4 - 1;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.f1052a.z();
        } else {
            this.f1052a.a(adVar);
        }
        this.f1052a.m = null;
        System.gc();
    }
}
