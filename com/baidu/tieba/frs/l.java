package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bv;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.f1105a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bb bbVar;
        boolean z;
        bv bvVar;
        bb bbVar2;
        bv bvVar2;
        String str;
        String str2;
        bb bbVar3;
        bb bbVar4;
        String str3;
        String str4;
        bb bbVar5;
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        bb bbVar6;
        bb bbVar7;
        bb bbVar8;
        bb bbVar9;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        String str5;
        com.baidu.tieba.model.aa aaVar5;
        com.baidu.tieba.model.aa aaVar6;
        bbVar = this.f1105a.l;
        bbVar.c(false);
        if (obj == null || !(obj instanceof com.baidu.tieba.data.bb)) {
            z = false;
        } else {
            com.baidu.tieba.model.p a2 = com.baidu.tieba.model.p.a();
            str5 = this.f1105a.c;
            a2.b(str5);
            aaVar5 = this.f1105a.v;
            aaVar5.a((com.baidu.tieba.data.bb) obj);
            TiebaApplication g = TiebaApplication.g();
            aaVar6 = this.f1105a.v;
            g.c(aaVar6.a().b());
            z = true;
        }
        if (!z) {
            bvVar = this.f1105a.x;
            if (bvVar.getErrorCode() == 160002) {
                str = this.f1105a.A;
                if (str == "normal_page") {
                    bbVar4 = this.f1105a.l;
                    bbVar4.f(1);
                } else {
                    str2 = this.f1105a.A;
                    if (str2 == "frs_page") {
                        bbVar3 = this.f1105a.l;
                        bbVar3.e(1);
                    }
                }
            }
            bbVar2 = this.f1105a.l;
            bvVar2 = this.f1105a.x;
            bbVar2.a(bvVar2.getErrorString());
            return;
        }
        str3 = this.f1105a.A;
        if (str3 == "normal_page") {
            bbVar9 = this.f1105a.l;
            aaVar3 = this.f1105a.v;
            int b = aaVar3.a().i().b();
            aaVar4 = this.f1105a.v;
            bbVar9.b(b, aaVar4.a().i().d());
        } else {
            str4 = this.f1105a.A;
            if (str4 == "frs_page") {
                bbVar5 = this.f1105a.l;
                aaVar = this.f1105a.v;
                int b2 = aaVar.a().i().b();
                aaVar2 = this.f1105a.v;
                bbVar5.a(b2, aaVar2.a().i().d());
            }
        }
        StringBuilder sb = new StringBuilder(100);
        bbVar6 = this.f1105a.l;
        if (!bbVar6.r()) {
            sb.append(this.f1105a.getString(R.string.sign_success));
            sb.append("!\n");
            sb.append(String.format(this.f1105a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.bb) obj).c())));
            bbVar8 = this.f1105a.l;
            bbVar8.a(sb.toString());
            return;
        }
        sb.append(this.f1105a.getString(R.string.sign_success));
        sb.append(",");
        sb.append(String.format(this.f1105a.getString(R.string.sign_point), Integer.valueOf(((com.baidu.tieba.data.bb) obj).d())));
        sb.append("!\n");
        sb.append(String.format(this.f1105a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.bb) obj).c())));
        bbVar7 = this.f1105a.l;
        bbVar7.a(sb.toString());
    }
}
