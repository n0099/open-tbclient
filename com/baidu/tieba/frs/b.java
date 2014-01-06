package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements af {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        bo boVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                boVar3 = this.a.n;
                boVar3.c(true);
                boVar4 = this.a.n;
                boVar4.r();
                return;
            case 2:
                boVar = this.a.n;
                boVar.d(true);
                boVar2 = this.a.n;
                boVar2.r();
                return;
            case 3:
                boVar5 = this.a.n;
                boVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.an anVar) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        bo boVar5;
        bo boVar6;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        boolean z;
        String str;
        String str2;
        String str3;
        bo boVar7;
        com.baidu.tieba.model.ak akVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        bo boVar8;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.model.ak akVar6;
        int i2;
        int i3;
        bo boVar9;
        bo boVar10;
        com.baidu.tieba.model.ak akVar7;
        com.baidu.tieba.model.ak akVar8;
        com.baidu.tieba.model.ak akVar9;
        boolean z2;
        bo boVar11;
        bo boVar12;
        if (UtilHelper.g(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            boVar12 = this.a.n;
            boVar12.h();
        } else {
            boVar = this.a.n;
            boVar.i();
        }
        if (anVar == null || !anVar.b) {
            int unused = FrsActivity.s = 1;
        } else {
            boVar11 = this.a.n;
            boVar11.n().a(com.baidu.tieba.util.bn.a().b());
            long unused2 = FrsActivity.q = 0L;
            long unused3 = FrsActivity.r = 0L;
            int unused4 = FrsActivity.s = 0;
        }
        boVar2 = this.a.n;
        boVar2.b(false);
        switch (i) {
            case 1:
                boVar5 = this.a.n;
                boVar5.c(false);
                boVar6 = this.a.n;
                boVar6.r();
                break;
            case 2:
                boVar3 = this.a.n;
                boVar3.d(false);
                boVar4 = this.a.n;
                boVar4.r();
                break;
        }
        if (jSONObject == null || (anVar != null && anVar.c != 0)) {
            this.a.a(anVar);
        } else {
            akVar = this.a.w;
            if (akVar != null) {
                akVar8 = this.a.w;
                if (akVar8.f().a() == 1) {
                    this.a.C = "frs_page";
                } else {
                    this.a.C = "normal_page";
                }
                FrsActivity frsActivity = this.a;
                akVar9 = this.a.w;
                frsActivity.f = akVar9.a().getName();
                z2 = this.a.u;
                if (z2) {
                    this.a.C = "good_page";
                }
            }
            akVar2 = this.a.w;
            com.baidu.tieba.data.bd top_notice_data = akVar2.a().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tieba.data.bb bbVar = new com.baidu.tieba.data.bb();
                bbVar.c(top_notice_data.a());
                bbVar.a(2);
                bbVar.b(top_notice_data.b());
                bbVar.t();
                akVar7 = this.a.w;
                akVar7.b().add(0, bbVar);
            }
            z = this.a.v;
            if (z) {
                boVar10 = this.a.n;
                boVar10.B();
                this.a.v = false;
            }
            str = this.a.C;
            if (str.equals("frs_page")) {
                boVar9 = this.a.n;
                boVar9.t();
            } else {
                str2 = this.a.C;
                if (str2.equals("normal_page")) {
                    boVar8 = this.a.n;
                    boVar8.s();
                } else {
                    str3 = this.a.C;
                    if (str3.equals("good_page")) {
                        boVar7 = this.a.n;
                        akVar3 = this.a.w;
                        ArrayList<com.baidu.tieba.data.aa> good_classify = akVar3.a().getGood_classify();
                        onItemClickListener = this.a.ad;
                        boVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            long unused5 = FrsActivity.q = (System.nanoTime() - this.b) / 1000000;
            if (anVar != null) {
                long unused6 = FrsActivity.r = anVar.e;
            }
            akVar4 = this.a.w;
            if (akVar4 != null) {
                akVar5 = this.a.w;
                if (akVar5.b() != null) {
                    akVar6 = this.a.w;
                    if (akVar6.b().size() == 0) {
                        i2 = this.a.e;
                        if (i2 == 1) {
                            this.a.showToast(this.a.getString(R.string.no_more_to_load));
                            i3 = this.a.i;
                            if (i3 > 1) {
                                FrsActivity.i(this.a);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.a.E();
        }
        this.a.o = null;
        System.gc();
    }

    @Override // com.baidu.tieba.frs.af
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
