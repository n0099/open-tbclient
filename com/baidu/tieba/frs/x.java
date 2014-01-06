package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        bo boVar2;
        bo boVar3;
        String str;
        String str2;
        com.baidu.tieba.model.ak akVar;
        bo boVar4;
        bo boVar5;
        try {
            boVar = this.a.n;
            boVar.n().a().a();
            boVar2 = this.a.n;
            boVar2.p().a().a();
            boVar3 = this.a.n;
            boVar3.o().a().a();
            str = this.a.C;
            if (!str.equals("frs_page")) {
                str2 = this.a.C;
                if (str2.equals("normal_page")) {
                    akVar = this.a.w;
                    String image_url = akVar.a().getImage_url();
                    if (image_url != null && image_url.length() > 0) {
                        this.a.b();
                    }
                }
            } else {
                this.a.d();
            }
            this.a.m();
            if (com.baidu.tieba.e.a.a().f()) {
                boVar4 = this.a.n;
                BdListView D = boVar4.D();
                boVar5 = this.a.n;
                com.baidu.tieba.util.ak.a(D, boVar5.n().a(), this.a.b, null, null, 0, -1);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
