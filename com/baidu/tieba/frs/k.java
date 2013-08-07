package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.f1085a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        az azVar;
        com.baidu.tieba.model.ar arVar;
        az azVar2;
        com.baidu.tieba.model.ar arVar2;
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
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        boolean z = false;
        azVar = this.f1085a.l;
        azVar.c(false);
        if (obj != null && (obj instanceof com.baidu.tieba.data.ak)) {
            aaVar4 = this.f1085a.v;
            aaVar4.a((com.baidu.tieba.data.ak) obj);
            z = true;
        }
        if (!z) {
            arVar = this.f1085a.w;
            if (arVar.getErrorCode() == 22) {
                str = this.f1085a.A;
                if (str == "normal_page") {
                    azVar4 = this.f1085a.l;
                    azVar4.g(1);
                } else {
                    str2 = this.f1085a.A;
                    if (str2 == "frs_page") {
                        azVar3 = this.f1085a.l;
                        azVar3.h(1);
                    }
                }
            }
            azVar2 = this.f1085a.l;
            arVar2 = this.f1085a.w;
            azVar2.a(arVar2.getErrorString());
            return;
        }
        str3 = this.f1085a.A;
        if (str3 == "normal_page") {
            azVar7 = this.f1085a.l;
            aaVar3 = this.f1085a.v;
            azVar7.a(1, aaVar3.a());
        } else {
            str4 = this.f1085a.A;
            if (str4 == "frs_page") {
                azVar5 = this.f1085a.l;
                aaVar = this.f1085a.v;
                com.baidu.tieba.data.v a2 = aaVar.a();
                aaVar2 = this.f1085a.v;
                azVar5.a(1, a2, aaVar2.e());
            }
        }
        azVar6 = this.f1085a.l;
        azVar6.a(this.f1085a.getString(R.string.like_success));
        TiebaApplication.f().j(true);
    }
}
