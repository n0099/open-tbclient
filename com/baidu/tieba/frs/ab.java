package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        br brVar2;
        br brVar3;
        String str;
        String str2;
        com.baidu.tieba.model.z zVar;
        br brVar4;
        br brVar5;
        try {
            brVar = this.a.p;
            brVar.n().a().a();
            brVar2 = this.a.p;
            brVar2.p().a().a();
            brVar3 = this.a.p;
            brVar3.o().a().a();
            str = this.a.G;
            if (!str.equals("frs_page")) {
                str2 = this.a.G;
                if (str2.equals("normal_page")) {
                    zVar = this.a.A;
                    String image_url = zVar.b().getImage_url();
                    if (image_url != null && image_url.length() > 0) {
                        this.a.b();
                    }
                }
            } else {
                this.a.e();
            }
            this.a.n();
            if (com.baidu.tieba.h.a.a().f()) {
                brVar4 = this.a.p;
                BdListView D = brVar4.D();
                brVar5 = this.a.p;
                com.baidu.tieba.util.ap.a(D, brVar5.n().a(), this.a.c, null, null, 0, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
