package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.f1152a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ba baVar;
        com.baidu.tieba.model.as asVar;
        ba baVar2;
        String str;
        String str2;
        ba baVar3;
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        ba baVar4;
        String str3;
        ba baVar5;
        com.baidu.tieba.model.ac acVar3;
        com.baidu.tieba.model.ac acVar4;
        boolean z = false;
        baVar = this.f1152a.o;
        baVar.c(false);
        if (obj != null && (obj instanceof com.baidu.tieba.data.ag)) {
            acVar4 = this.f1152a.x;
            acVar4.a((com.baidu.tieba.data.ag) obj);
            z = true;
        }
        if (!z) {
            asVar = this.f1152a.y;
            asVar.getErrorCode();
            baVar2 = this.f1152a.o;
            baVar2.a(this.f1152a.getString(R.string.had_liked_forum));
            this.f1152a.D();
            return;
        }
        str = this.f1152a.C;
        if (str.equals("normal_page")) {
            baVar5 = this.f1152a.o;
            acVar3 = this.f1152a.x;
            baVar5.a(1, acVar3.a());
        } else {
            str2 = this.f1152a.C;
            if (str2.equals("frs_page")) {
                baVar3 = this.f1152a.o;
                acVar = this.f1152a.x;
                com.baidu.tieba.data.v a2 = acVar.a();
                acVar2 = this.f1152a.x;
                baVar3.a(1, a2, acVar2.e());
            }
        }
        baVar4 = this.f1152a.o;
        baVar4.a(this.f1152a.getString(R.string.like_success));
        TiebaApplication g = TiebaApplication.g();
        str3 = this.f1152a.e;
        g.e(str3);
    }
}
