package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.f1297a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba baVar;
        ba baVar2;
        ba baVar3;
        String str;
        String str2;
        com.baidu.tieba.model.ak akVar;
        ba baVar4;
        ba baVar5;
        try {
            baVar = this.f1297a.o;
            baVar.h().a().a();
            baVar2 = this.f1297a.o;
            baVar2.j().a().a();
            baVar3 = this.f1297a.o;
            baVar3.i().a().a();
            str = this.f1297a.C;
            if (!str.equals("frs_page")) {
                str2 = this.f1297a.C;
                if (str2.equals("normal_page")) {
                    akVar = this.f1297a.x;
                    String image_url = akVar.a().getImage_url();
                    if (image_url != null && image_url.length() > 0) {
                        this.f1297a.c();
                    }
                }
            } else {
                this.f1297a.d();
            }
            int i = TiebaApplication.g().ar() ? 0 : 1;
            baVar4 = this.f1297a.o;
            BdListView t = baVar4.t();
            baVar5 = this.f1297a.o;
            com.baidu.tieba.util.ab.a(t, baVar5.h().a(), i, -1);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
