package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
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
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        az azVar5;
        az azVar6;
        com.baidu.tieba.model.v vVar3;
        com.baidu.tieba.model.v vVar4;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ac)) {
            vVar4 = this.a.v;
            vVar4.a((com.baidu.tieba.data.ac) obj);
            z = true;
        }
        if (!z) {
            ajVar = this.a.w;
            if (ajVar.getErrorCode() == 22) {
                str = this.a.A;
                if (str == "normal_page") {
                    azVar3 = this.a.l;
                    azVar3.g(1);
                } else {
                    str2 = this.a.A;
                    if (str2 == "frs_page") {
                        azVar2 = this.a.l;
                        azVar2.h(1);
                    }
                }
            }
            azVar = this.a.l;
            ajVar2 = this.a.w;
            azVar.a(ajVar2.getErrorString());
            return;
        }
        str3 = this.a.A;
        if (str3 == "normal_page") {
            azVar6 = this.a.l;
            vVar3 = this.a.v;
            azVar6.a(1, vVar3.a());
        } else {
            str4 = this.a.A;
            if (str4 == "frs_page") {
                azVar4 = this.a.l;
                vVar = this.a.v;
                com.baidu.tieba.data.r a = vVar.a();
                vVar2 = this.a.v;
                azVar4.a(1, a, vVar2.e());
            }
        }
        azVar5 = this.a.l;
        azVar5.a(this.a.getString(R.string.like_success));
        TiebaApplication.f().i(true);
    }
}
