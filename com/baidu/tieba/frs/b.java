package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b implements ag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1326a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.f1326a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bn bnVar5;
        this.b = System.nanoTime();
        switch (i) {
            case 1:
                bnVar3 = this.f1326a.n;
                bnVar3.c(true);
                bnVar4 = this.f1326a.n;
                bnVar4.p();
                return;
            case 2:
                bnVar = this.f1326a.n;
                bnVar.d(true);
                bnVar2 = this.f1326a.n;
                bnVar2.p();
                return;
            case 3:
                bnVar5 = this.f1326a.n;
                bnVar5.b(true);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.an anVar) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        boolean z;
        String str;
        String str2;
        String str3;
        bn bnVar7;
        com.baidu.tieba.model.ak akVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        bn bnVar8;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.model.ak akVar6;
        int i2;
        int i3;
        bn bnVar9;
        bn bnVar10;
        com.baidu.tieba.model.ak akVar7;
        com.baidu.tieba.model.ak akVar8;
        com.baidu.tieba.model.ak akVar9;
        boolean z2;
        bn bnVar11;
        bn bnVar12;
        if (UtilHelper.i(this.f1326a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bnVar12 = this.f1326a.n;
            bnVar12.g();
        } else {
            bnVar = this.f1326a.n;
            bnVar.h();
        }
        if (anVar == null || !anVar.b) {
            int unused = FrsActivity.s = 1;
        } else {
            bnVar11 = this.f1326a.n;
            bnVar11.l().a(com.baidu.tieba.util.bf.a().b());
            long unused2 = FrsActivity.q = 0L;
            long unused3 = FrsActivity.r = 0L;
            int unused4 = FrsActivity.s = 0;
        }
        bnVar2 = this.f1326a.n;
        bnVar2.b(false);
        switch (i) {
            case 1:
                bnVar5 = this.f1326a.n;
                bnVar5.c(false);
                bnVar6 = this.f1326a.n;
                bnVar6.p();
                break;
            case 2:
                bnVar3 = this.f1326a.n;
                bnVar3.d(false);
                bnVar4 = this.f1326a.n;
                bnVar4.p();
                break;
        }
        if (jSONObject == null || (anVar != null && anVar.c != 0)) {
            this.f1326a.a(anVar);
        } else {
            akVar = this.f1326a.w;
            if (akVar != null) {
                akVar8 = this.f1326a.w;
                if (akVar8.f().a() == 1) {
                    this.f1326a.C = "frs_page";
                } else {
                    this.f1326a.C = "normal_page";
                }
                FrsActivity frsActivity = this.f1326a;
                akVar9 = this.f1326a.w;
                frsActivity.f = akVar9.a().getName();
                z2 = this.f1326a.u;
                if (z2) {
                    this.f1326a.C = "good_page";
                }
            }
            akVar2 = this.f1326a.w;
            com.baidu.tieba.data.bc top_notice_data = akVar2.a().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tieba.data.ba baVar = new com.baidu.tieba.data.ba();
                baVar.c(top_notice_data.a());
                baVar.a(2);
                baVar.b(top_notice_data.b());
                baVar.t();
                akVar7 = this.f1326a.w;
                akVar7.b().add(0, baVar);
            }
            z = this.f1326a.v;
            if (z) {
                bnVar10 = this.f1326a.n;
                bnVar10.z();
                this.f1326a.v = false;
            }
            str = this.f1326a.C;
            if (str.equals("frs_page")) {
                bnVar9 = this.f1326a.n;
                bnVar9.r();
            } else {
                str2 = this.f1326a.C;
                if (str2.equals("normal_page")) {
                    bnVar8 = this.f1326a.n;
                    bnVar8.q();
                } else {
                    str3 = this.f1326a.C;
                    if (str3.equals("good_page")) {
                        bnVar7 = this.f1326a.n;
                        akVar3 = this.f1326a.w;
                        ArrayList<com.baidu.tieba.data.z> good_classify = akVar3.a().getGood_classify();
                        onItemClickListener = this.f1326a.ad;
                        bnVar7.a(good_classify, onItemClickListener);
                    }
                }
            }
            long unused5 = FrsActivity.q = (System.nanoTime() - this.b) / 1000000;
            if (anVar != null) {
                long unused6 = FrsActivity.r = anVar.e;
            }
            akVar4 = this.f1326a.w;
            if (akVar4 != null) {
                akVar5 = this.f1326a.w;
                if (akVar5.b() != null) {
                    akVar6 = this.f1326a.w;
                    if (akVar6.b().size() == 0) {
                        i2 = this.f1326a.e;
                        if (i2 == 1) {
                            this.f1326a.showToast(this.f1326a.getString(R.string.no_more_to_load));
                            i3 = this.f1326a.i;
                            if (i3 > 1) {
                                FrsActivity.i(this.f1326a);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            this.f1326a.D();
        }
        this.f1326a.o = null;
        System.gc();
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(com.baidu.tieba.model.ak akVar) {
        String str;
        String str2;
        if (akVar != null) {
            str = this.f1326a.C;
            if (!str.equals("normal_page")) {
                str2 = this.f1326a.C;
                if (!str2.equals("frs_page")) {
                    return;
                }
            }
            this.f1326a.a(akVar);
        }
    }
}
