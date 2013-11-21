package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.f1374a = frsActivity;
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
            bnVar = this.f1374a.n;
            bnVar.l().a().a();
            bnVar2 = this.f1374a.n;
            bnVar2.n().a().a();
            bnVar3 = this.f1374a.n;
            bnVar3.m().a().a();
            str = this.f1374a.C;
            if (!str.equals("frs_page")) {
                str2 = this.f1374a.C;
                if (str2.equals("normal_page")) {
                    akVar = this.f1374a.w;
                    String image_url = akVar.a().getImage_url();
                    if (image_url != null && image_url.length() > 0) {
                        this.f1374a.b();
                    }
                }
            } else {
                this.f1374a.d();
            }
            this.f1374a.m();
            if (com.baidu.tieba.d.a.a().f()) {
                bnVar4 = this.f1374a.n;
                BdListView B = bnVar4.B();
                bnVar5 = this.f1374a.n;
                com.baidu.tieba.util.ak.a(B, bnVar5.l().a(), this.f1374a.b, null, 0, -1);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
