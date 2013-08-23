package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.f1104a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bb bbVar;
        com.baidu.tieba.model.aq aqVar;
        bb bbVar2;
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
        String str5;
        bb bbVar7;
        com.baidu.tieba.model.aa aaVar3;
        com.baidu.tieba.model.aa aaVar4;
        boolean z = false;
        bbVar = this.f1104a.l;
        bbVar.c(false);
        if (obj != null && (obj instanceof com.baidu.tieba.data.ag)) {
            aaVar4 = this.f1104a.v;
            aaVar4.a((com.baidu.tieba.data.ag) obj);
            z = true;
        }
        if (!z) {
            aqVar = this.f1104a.w;
            if (aqVar.getErrorCode() == 22) {
                str = this.f1104a.A;
                if (str == "normal_page") {
                    bbVar4 = this.f1104a.l;
                    bbVar4.g(1);
                } else {
                    str2 = this.f1104a.A;
                    if (str2 == "frs_page") {
                        bbVar3 = this.f1104a.l;
                        bbVar3.h(1);
                    }
                }
            }
            bbVar2 = this.f1104a.l;
            bbVar2.a(this.f1104a.getString(R.string.had_liked_forum));
            return;
        }
        str3 = this.f1104a.A;
        if (str3 == "normal_page") {
            bbVar7 = this.f1104a.l;
            aaVar3 = this.f1104a.v;
            bbVar7.a(1, aaVar3.a());
        } else {
            str4 = this.f1104a.A;
            if (str4 == "frs_page") {
                bbVar5 = this.f1104a.l;
                aaVar = this.f1104a.v;
                com.baidu.tieba.data.v a2 = aaVar.a();
                aaVar2 = this.f1104a.v;
                bbVar5.a(1, a2, aaVar2.e());
            }
        }
        bbVar6 = this.f1104a.l;
        bbVar6.a(this.f1104a.getString(R.string.like_success));
        TiebaApplication g = TiebaApplication.g();
        str5 = this.f1104a.c;
        g.e(str5);
    }
}
