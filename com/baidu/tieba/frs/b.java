package com.baidu.tieba.frs;

import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b implements ag {
    final /* synthetic */ FrsActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.a = frsActivity;
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
                bnVar3 = this.a.n;
                bnVar3.c(true);
                bnVar4 = this.a.n;
                bnVar4.q();
                return;
            case 2:
                bnVar = this.a.n;
                bnVar.d(true);
                bnVar2 = this.a.n;
                bnVar2.q();
                return;
            case 3:
                bnVar5 = this.a.n;
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
        if (UtilHelper.g(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bnVar12 = this.a.n;
            bnVar12.h();
        } else {
            bnVar = this.a.n;
            bnVar.i();
        }
        if (anVar == null || !anVar.b) {
            int unused = FrsActivity.s = 1;
        } else {
            bnVar11 = this.a.n;
            bnVar11.m().a(com.baidu.tieba.util.bd.a().b());
            long unused2 = FrsActivity.q = 0L;
            long unused3 = FrsActivity.r = 0L;
            int unused4 = FrsActivity.s = 0;
        }
        bnVar2 = this.a.n;
        bnVar2.b(false);
        switch (i) {
            case 1:
                bnVar5 = this.a.n;
                bnVar5.c(false);
                bnVar6 = this.a.n;
                bnVar6.q();
                break;
            case 2:
                bnVar3 = this.a.n;
                bnVar3.d(false);
                bnVar4 = this.a.n;
                bnVar4.q();
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
            com.baidu.tieba.data.bb top_notice_data = akVar2.a().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.a() != null) {
                com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                azVar.c(top_notice_data.a());
                azVar.a(2);
                azVar.b(top_notice_data.b());
                azVar.t();
                akVar7 = this.a.w;
                akVar7.b().add(0, azVar);
            }
            z = this.a.v;
            if (z) {
                bnVar10 = this.a.n;
                bnVar10.A();
                this.a.v = false;
            }
            str = this.a.C;
            if (str.equals("frs_page")) {
                bnVar9 = this.a.n;
                bnVar9.s();
            } else {
                str2 = this.a.C;
                if (str2.equals("normal_page")) {
                    bnVar8 = this.a.n;
                    bnVar8.r();
                } else {
                    str3 = this.a.C;
                    if (str3.equals("good_page")) {
                        bnVar7 = this.a.n;
                        akVar3 = this.a.w;
                        ArrayList<com.baidu.tieba.data.z> good_classify = akVar3.a().getGood_classify();
                        onItemClickListener = this.a.ad;
                        bnVar7.a(good_classify, onItemClickListener);
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
            this.a.D();
        }
        this.a.o = null;
        System.gc();
    }

    @Override // com.baidu.tieba.frs.ag
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
