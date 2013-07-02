package com.baidu.tieba.frs;

import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
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
        az azVar5;
        az azVar6;
        az azVar7;
        az azVar8;
        if (obj == null || !(obj instanceof com.baidu.tieba.data.av)) {
            z = false;
        } else {
            this.a.a.a((com.baidu.tieba.data.av) obj);
            TiebaApplication.f().c(this.a.a.a().b());
            z = true;
        }
        if (!z) {
            bnVar = this.a.x;
            if (bnVar.getErrorCode() == 160002) {
                str = this.a.A;
                if (str == "normal_page") {
                    azVar3 = this.a.m;
                    azVar3.f(1);
                } else {
                    str2 = this.a.A;
                    if (str2 == "frs_page") {
                        azVar2 = this.a.m;
                        azVar2.e(1);
                    }
                }
            }
            azVar = this.a.m;
            bnVar2 = this.a.x;
            azVar.a(bnVar2.getErrorString());
            return;
        }
        str3 = this.a.A;
        if (str3 == "normal_page") {
            azVar8 = this.a.m;
            azVar8.b(this.a.a.a().g().b(), this.a.a.a().g().f());
        } else {
            str4 = this.a.A;
            if (str4 == "frs_page") {
                azVar4 = this.a.m;
                azVar4.a(this.a.a.a().g().b(), this.a.a.a().g().f());
            }
        }
        StringBuilder sb = new StringBuilder(100);
        azVar5 = this.a.m;
        if (!azVar5.p()) {
            sb.append(this.a.getString(R.string.sign_success));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.av) obj).c())));
            azVar7 = this.a.m;
            azVar7.a(sb.toString());
            return;
        }
        sb.append(this.a.getString(R.string.sign_success));
        sb.append(",");
        sb.append(String.format(this.a.getString(R.string.sign_point), Integer.valueOf(((com.baidu.tieba.data.av) obj).f())));
        sb.append("!\n");
        sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.av) obj).c())));
        azVar6 = this.a.m;
        azVar6.a(sb.toString());
    }
}
