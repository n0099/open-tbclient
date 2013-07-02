package com.baidu.tieba.frs;

import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.aj ajVar;
        az azVar;
        com.baidu.tieba.model.aj ajVar2;
        String str;
        String str2;
        az azVar2;
        az azVar3;
        String str3;
        String str4;
        az azVar4;
        az azVar5;
        az azVar6;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ac)) {
            this.a.a.a((com.baidu.tieba.data.ac) obj);
            z = true;
        }
        if (!z) {
            ajVar = this.a.w;
            if (ajVar.getErrorCode() == 22) {
                str = this.a.A;
                if (str == "normal_page") {
                    azVar3 = this.a.m;
                    azVar3.g(1);
                } else {
                    str2 = this.a.A;
                    if (str2 == "frs_page") {
                        azVar2 = this.a.m;
                        azVar2.h(1);
                    }
                }
            }
            azVar = this.a.m;
            ajVar2 = this.a.w;
            azVar.a(ajVar2.getErrorString());
            return;
        }
        str3 = this.a.A;
        if (str3 == "normal_page") {
            azVar6 = this.a.m;
            azVar6.a(1, this.a.a.a());
        } else {
            str4 = this.a.A;
            if (str4 == "frs_page") {
                azVar4 = this.a.m;
                azVar4.a(1, this.a.a.a(), this.a.a.e());
            }
        }
        azVar5 = this.a.m;
        azVar5.a(this.a.getString(R.string.like_success));
        TiebaApplication.f().h(true);
    }
}
