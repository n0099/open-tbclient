package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bn;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.f864a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        boolean z;
        bn bnVar;
        az azVar;
        bn bnVar2;
        String str;
        String str2;
        az azVar2;
        az azVar3;
        String str3;
        String str4;
        az azVar4;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        az azVar5;
        az azVar6;
        az azVar7;
        az azVar8;
        com.baidu.tieba.model.v vVar3;
        com.baidu.tieba.model.v vVar4;
        com.baidu.tieba.model.v vVar5;
        com.baidu.tieba.model.v vVar6;
        if (obj == null || !(obj instanceof com.baidu.tieba.data.av)) {
            z = false;
        } else {
            vVar5 = this.f864a.v;
            vVar5.a((com.baidu.tieba.data.av) obj);
            TiebaApplication f = TiebaApplication.f();
            vVar6 = this.f864a.v;
            f.c(vVar6.a().b());
            z = true;
        }
        if (!z) {
            bnVar = this.f864a.x;
            if (bnVar.getErrorCode() == 160002) {
                str = this.f864a.A;
                if (str == "normal_page") {
                    azVar3 = this.f864a.l;
                    azVar3.f(1);
                } else {
                    str2 = this.f864a.A;
                    if (str2 == "frs_page") {
                        azVar2 = this.f864a.l;
                        azVar2.e(1);
                    }
                }
            }
            azVar = this.f864a.l;
            bnVar2 = this.f864a.x;
            azVar.a(bnVar2.getErrorString());
            return;
        }
        str3 = this.f864a.A;
        if (str3 == "normal_page") {
            azVar8 = this.f864a.l;
            vVar3 = this.f864a.v;
            int b = vVar3.a().g().b();
            vVar4 = this.f864a.v;
            azVar8.b(b, vVar4.a().g().d());
        } else {
            str4 = this.f864a.A;
            if (str4 == "frs_page") {
                azVar4 = this.f864a.l;
                vVar = this.f864a.v;
                int b2 = vVar.a().g().b();
                vVar2 = this.f864a.v;
                azVar4.a(b2, vVar2.a().g().d());
            }
        }
        StringBuilder sb = new StringBuilder(100);
        azVar5 = this.f864a.l;
        if (!azVar5.p()) {
            sb.append(this.f864a.getString(R.string.sign_success));
            sb.append("!\n");
            sb.append(String.format(this.f864a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.av) obj).c())));
            azVar7 = this.f864a.l;
            azVar7.a(sb.toString());
            return;
        }
        sb.append(this.f864a.getString(R.string.sign_success));
        sb.append(",");
        sb.append(String.format(this.f864a.getString(R.string.sign_point), Integer.valueOf(((com.baidu.tieba.data.av) obj).d())));
        sb.append("!\n");
        sb.append(String.format(this.f864a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.av) obj).c())));
        azVar6 = this.f864a.l;
        azVar6.a(sb.toString());
    }
}
