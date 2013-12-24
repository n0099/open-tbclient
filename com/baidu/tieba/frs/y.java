package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        String str;
        String str2;
        com.baidu.tieba.model.ak akVar;
        bn bnVar4;
        bn bnVar5;
        try {
            bnVar = this.a.n;
            bnVar.m().a().a();
            bnVar2 = this.a.n;
            bnVar2.o().a().a();
            bnVar3 = this.a.n;
            bnVar3.n().a().a();
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
            if (com.baidu.tieba.d.a.a().f()) {
                bnVar4 = this.a.n;
                BdListView C = bnVar4.C();
                bnVar5 = this.a.n;
                com.baidu.tieba.util.ai.a(C, bnVar5.m().a(), this.a.b, null, 0, -1);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
