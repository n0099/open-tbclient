package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        String str;
        String str2;
        com.baidu.tieba.model.ak akVar;
        bk bkVar4;
        bk bkVar5;
        try {
            bkVar = this.a.n;
            bkVar.n().a().a();
            bkVar2 = this.a.n;
            bkVar2.p().a().a();
            bkVar3 = this.a.n;
            bkVar3.o().a().a();
            str = this.a.C;
            if (!str.equals("frs_page")) {
                str2 = this.a.C;
                if (str2.equals("normal_page")) {
                    akVar = this.a.w;
                    String image_url = akVar.b().getImage_url();
                    if (image_url != null && image_url.length() > 0) {
                        this.a.b();
                    }
                }
            } else {
                this.a.d();
            }
            this.a.m();
            if (com.baidu.tieba.e.a.a().f()) {
                bkVar4 = this.a.n;
                BdListView D = bkVar4.D();
                bkVar5 = this.a.n;
                com.baidu.tieba.util.an.a(D, bkVar5.n().a(), this.a.b, null, null, 0, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
