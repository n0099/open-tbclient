package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bg;
import com.baidu.tieba.model.bw;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.f1088a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        az azVar;
        boolean z;
        bw bwVar;
        az azVar2;
        bw bwVar2;
        String str;
        String str2;
        az azVar3;
        az azVar4;
        String str3;
        String str4;
        az azVar5;
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        az azVar6;
        az azVar7;
        az azVar8;
        az azVar9;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.model.aa aaVar5;
        com.baidu.tieba.model.aa aaVar6;
        azVar = this.f1088a.l;
        azVar.c(false);
        if (obj == null || !(obj instanceof bg)) {
            z = false;
        } else {
            aaVar5 = this.f1088a.v;
            aaVar5.a((bg) obj);
            TiebaApplication f = TiebaApplication.f();
            aaVar6 = this.f1088a.v;
            f.c(aaVar6.a().b());
            z = true;
        }
        if (!z) {
            bwVar = this.f1088a.x;
            if (bwVar.getErrorCode() == 160002) {
                str = this.f1088a.A;
                if (str == "normal_page") {
                    azVar4 = this.f1088a.l;
                    azVar4.f(1);
                } else {
                    str2 = this.f1088a.A;
                    if (str2 == "frs_page") {
                        azVar3 = this.f1088a.l;
                        azVar3.e(1);
                    }
                }
            }
            azVar2 = this.f1088a.l;
            bwVar2 = this.f1088a.x;
            azVar2.a(bwVar2.getErrorString());
            return;
        }
        str3 = this.f1088a.A;
        if (str3 == "normal_page") {
            azVar9 = this.f1088a.l;
            aaVar3 = this.f1088a.v;
            int b = aaVar3.a().i().b();
            aaVar4 = this.f1088a.v;
            azVar9.b(b, aaVar4.a().i().d());
        } else {
            str4 = this.f1088a.A;
            if (str4 == "frs_page") {
                azVar5 = this.f1088a.l;
                aaVar = this.f1088a.v;
                int b2 = aaVar.a().i().b();
                aaVar2 = this.f1088a.v;
                azVar5.a(b2, aaVar2.a().i().d());
            }
        }
        StringBuilder sb = new StringBuilder(100);
        azVar6 = this.f1088a.l;
        if (!azVar6.p()) {
            sb.append(this.f1088a.getString(R.string.sign_success));
            sb.append("!\n");
            sb.append(String.format(this.f1088a.getString(R.string.sign_user), Integer.valueOf(((bg) obj).c())));
            azVar8 = this.f1088a.l;
            azVar8.a(sb.toString());
            return;
        }
        sb.append(this.f1088a.getString(R.string.sign_success));
        sb.append(",");
        sb.append(String.format(this.f1088a.getString(R.string.sign_point), Integer.valueOf(((bg) obj).d())));
        sb.append("!\n");
        sb.append(String.format(this.f1088a.getString(R.string.sign_user), Integer.valueOf(((bg) obj).c())));
        azVar7 = this.f1088a.l;
        azVar7.a(sb.toString());
    }
}
