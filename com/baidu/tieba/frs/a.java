package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a implements ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1064a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.f1064a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ae
    public void a(int i) {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        bb bbVar4;
        bb bbVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                bbVar3 = this.f1064a.l;
                bbVar3.d(true);
                bbVar4 = this.f1064a.l;
                bbVar4.m();
                return;
            case 2:
                bbVar = this.f1064a.l;
                bbVar.e(true);
                bbVar2 = this.f1064a.l;
                bbVar2.m();
                return;
            case 3:
                bbVar5 = this.f1064a.l;
                bbVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ad adVar) {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        bb bbVar4;
        bb bbVar5;
        bb bbVar6;
        com.baidu.tieba.model.aa aaVar;
        boolean z;
        String str;
        String str2;
        String str3;
        bb bbVar7;
        com.baidu.tieba.model.aa aaVar2;
        AdapterView.OnItemClickListener onItemClickListener;
        bb bbVar8;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.model.aa aaVar5;
        int i2;
        int i3;
        int i4;
        bb bbVar9;
        bb bbVar10;
        com.baidu.tieba.model.aa aaVar6;
        com.baidu.tieba.model.aa aaVar7;
        boolean z2;
        bb bbVar11;
        bb bbVar12;
        if (UtilHelper.i(this.f1064a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bbVar12 = this.f1064a.l;
            bbVar12.c();
        } else {
            bbVar = this.f1064a.l;
            bbVar.d();
        }
        if (adVar != null && adVar.b) {
            bbVar11 = this.f1064a.l;
            bbVar11.i().b(TiebaApplication.g().aZ());
            FrsActivity.p = 0L;
            FrsActivity.q = 0L;
            FrsActivity.r = 0;
        } else {
            FrsActivity.r = 1;
        }
        bbVar2 = this.f1064a.l;
        bbVar2.b(false);
        switch (i) {
            case 1:
                bbVar5 = this.f1064a.l;
                bbVar5.d(false);
                bbVar6 = this.f1064a.l;
                bbVar6.m();
                break;
            case 2:
                bbVar3 = this.f1064a.l;
                bbVar3.e(false);
                bbVar4 = this.f1064a.l;
                bbVar4.m();
                break;
        }
        if (jSONObject != null && (adVar == null || adVar.c == 0)) {
            aaVar = this.f1064a.v;
            if (aaVar != null) {
                aaVar6 = this.f1064a.v;
                if (aaVar6.e().a() == 1) {
                    this.f1064a.A = "frs_page";
                } else {
                    this.f1064a.A = "normal_page";
                }
                FrsActivity frsActivity = this.f1064a;
                aaVar7 = this.f1064a.v;
                frsActivity.c = aaVar7.a().b();
                z2 = this.f1064a.t;
                if (z2) {
                    this.f1064a.A = "good_page";
                }
            }
            z = this.f1064a.u;
            if (z) {
                bbVar10 = this.f1064a.l;
                bbVar10.s();
                this.f1064a.u = false;
            }
            str = this.f1064a.A;
            if (str == "frs_page") {
                bbVar9 = this.f1064a.l;
                bbVar9.o();
            } else {
                str2 = this.f1064a.A;
                if (str2 == "normal_page") {
                    bbVar8 = this.f1064a.l;
                    bbVar8.n();
                } else {
                    str3 = this.f1064a.A;
                    if (str3 == "good_page") {
                        bbVar7 = this.f1064a.l;
                        aaVar2 = this.f1064a.v;
                        ArrayList j = aaVar2.a().j();
                        onItemClickListener = this.f1064a.Y;
                        bbVar7.a(j, onItemClickListener);
                    }
                }
            }
            FrsActivity.p = (System.nanoTime() - this.b) / 1000000;
            if (adVar != null) {
                FrsActivity.q = adVar.e;
            }
            aaVar3 = this.f1064a.v;
            if (aaVar3 != null) {
                aaVar4 = this.f1064a.v;
                if (aaVar4.b() != null) {
                    aaVar5 = this.f1064a.v;
                    if (aaVar5.b().size() == 0) {
                        i2 = this.f1064a.b;
                        if (i2 == 1) {
                            this.f1064a.a(this.f1064a.getString(R.string.no_more_to_load));
                            i3 = this.f1064a.f;
                            if (i3 > 1) {
                                FrsActivity frsActivity2 = this.f1064a;
                                i4 = frsActivity2.f;
                                frsActivity2.f = i4 - 1;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.f1064a.D();
        } else {
            this.f1064a.a(adVar);
        }
        this.f1064a.m = null;
        System.gc();
    }

    @Override // com.baidu.tieba.frs.ae
    public void a(com.baidu.tieba.model.aa aaVar) {
        String str;
        String str2;
        if (aaVar != null) {
            str = this.f1064a.A;
            if (!str.equals("normal_page")) {
                str2 = this.f1064a.A;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.f1064a.a(aaVar);
            this.f1064a.G = true;
        }
    }
}
