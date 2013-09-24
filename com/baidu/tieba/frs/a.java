package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a implements ad {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1112a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.f1112a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ad
    public void a(int i) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                baVar3 = this.f1112a.o;
                baVar3.d(true);
                baVar4 = this.f1112a.o;
                baVar4.k();
                return;
            case 2:
                baVar = this.f1112a.o;
                baVar.e(true);
                baVar2 = this.f1112a.o;
                baVar2.k();
                return;
            case 3:
                baVar5 = this.f1112a.o;
                baVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.ad
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.af afVar) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        ba baVar6;
        com.baidu.tieba.model.ac acVar;
        boolean z;
        String str;
        String str2;
        String str3;
        ba baVar7;
        com.baidu.tieba.model.ac acVar2;
        AdapterView.OnItemClickListener onItemClickListener;
        ba baVar8;
        com.baidu.tieba.model.ac acVar3;
        com.baidu.tieba.model.ac acVar4;
        com.baidu.tieba.model.ac acVar5;
        int i2;
        int i3;
        int i4;
        ba baVar9;
        ba baVar10;
        com.baidu.tieba.model.ac acVar6;
        com.baidu.tieba.model.ac acVar7;
        boolean z2;
        ba baVar11;
        ba baVar12;
        if (UtilHelper.i(this.f1112a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            baVar12 = this.f1112a.o;
            baVar12.c();
        } else {
            baVar = this.f1112a.o;
            baVar.d();
        }
        if (afVar != null && afVar.b) {
            baVar11 = this.f1112a.o;
            baVar11.g().b(com.baidu.tieba.util.au.a().b());
            FrsActivity.r = 0L;
            FrsActivity.s = 0L;
            FrsActivity.t = 0;
        } else {
            FrsActivity.t = 1;
        }
        baVar2 = this.f1112a.o;
        baVar2.b(false);
        switch (i) {
            case 1:
                baVar5 = this.f1112a.o;
                baVar5.d(false);
                baVar6 = this.f1112a.o;
                baVar6.k();
                break;
            case 2:
                baVar3 = this.f1112a.o;
                baVar3.e(false);
                baVar4 = this.f1112a.o;
                baVar4.k();
                break;
        }
        if (jSONObject != null && (afVar == null || afVar.c == 0)) {
            acVar = this.f1112a.x;
            if (acVar != null) {
                acVar6 = this.f1112a.x;
                if (acVar6.e().a() == 1) {
                    this.f1112a.C = "frs_page";
                } else {
                    this.f1112a.C = "normal_page";
                }
                FrsActivity frsActivity = this.f1112a;
                acVar7 = this.f1112a.x;
                frsActivity.e = acVar7.a().b();
                z2 = this.f1112a.v;
                if (z2) {
                    this.f1112a.C = "good_page";
                }
            }
            z = this.f1112a.w;
            if (z) {
                baVar10 = this.f1112a.o;
                baVar10.q();
                this.f1112a.w = false;
            }
            str = this.f1112a.C;
            if (str.equals("frs_page")) {
                baVar9 = this.f1112a.o;
                baVar9.m();
            } else {
                str2 = this.f1112a.C;
                if (str2.equals("normal_page")) {
                    baVar8 = this.f1112a.o;
                    baVar8.l();
                } else {
                    str3 = this.f1112a.C;
                    if (str3.equals("good_page")) {
                        baVar7 = this.f1112a.o;
                        acVar2 = this.f1112a.x;
                        ArrayList<com.baidu.tieba.data.aa> h = acVar2.a().h();
                        onItemClickListener = this.f1112a.Y;
                        baVar7.a(h, onItemClickListener);
                    }
                }
            }
            FrsActivity.r = (System.nanoTime() - this.b) / 1000000;
            if (afVar != null) {
                FrsActivity.s = afVar.e;
            }
            acVar3 = this.f1112a.x;
            if (acVar3 != null) {
                acVar4 = this.f1112a.x;
                if (acVar4.b() != null) {
                    acVar5 = this.f1112a.x;
                    if (acVar5.b().size() == 0) {
                        i2 = this.f1112a.d;
                        if (i2 == 1) {
                            this.f1112a.a(this.f1112a.getString(R.string.no_more_to_load));
                            i3 = this.f1112a.j;
                            if (i3 > 1) {
                                FrsActivity frsActivity2 = this.f1112a;
                                i4 = frsActivity2.j;
                                frsActivity2.j = i4 - 1;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.f1112a.G();
        } else {
            this.f1112a.a(afVar);
        }
        this.f1112a.p = null;
        System.gc();
    }

    @Override // com.baidu.tieba.frs.ad
    public void a(com.baidu.tieba.model.ac acVar) {
        String str;
        String str2;
        if (acVar != null) {
            str = this.f1112a.C;
            if (!str.equals("normal_page")) {
                str2 = this.f1112a.C;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.f1112a.a(acVar);
        }
    }
}
