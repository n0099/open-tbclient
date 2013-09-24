package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.f1162a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba baVar;
        ba baVar2;
        ba baVar3;
        String str;
        String str2;
        com.baidu.tieba.model.ac acVar;
        ba baVar4;
        ba baVar5;
        try {
            baVar = this.f1162a.o;
            baVar.g().a().a();
            baVar2 = this.f1162a.o;
            baVar2.i().a().a();
            baVar3 = this.f1162a.o;
            baVar3.h().a().a();
            str = this.f1162a.C;
            if (!str.equals("frs_page")) {
                str2 = this.f1162a.C;
                if (str2.equals("normal_page")) {
                    acVar = this.f1162a.x;
                    String l = acVar.a().l();
                    if (l != null && l.length() > 0) {
                        this.f1162a.c();
                    }
                }
            } else {
                this.f1162a.d();
            }
            int i = TiebaApplication.g().ao() ? 0 : 1;
            baVar4 = this.f1162a.o;
            BdListView s = baVar4.s();
            baVar5 = this.f1162a.o;
            com.baidu.tieba.util.u.a(s, baVar5.g().a(), i, -1);
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
