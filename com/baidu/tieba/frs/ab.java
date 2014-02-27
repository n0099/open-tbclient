package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class ab implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        String str;
        String str2;
        com.baidu.tieba.model.z zVar;
        bs bsVar4;
        bs bsVar5;
        try {
            bsVar = this.a.p;
            bsVar.m().a().a();
            bsVar2 = this.a.p;
            bsVar2.o().a().a();
            bsVar3 = this.a.p;
            bsVar3.n().a().a();
            str = this.a.G;
            if (!str.equals("frs_page")) {
                str2 = this.a.G;
                if (str2.equals("normal_page")) {
                    zVar = this.a.A;
                    String image_url = zVar.f().getImage_url();
                    if (image_url != null && image_url.length() > 0) {
                        this.a.d();
                    }
                }
            } else {
                this.a.f();
            }
            this.a.l();
            if (com.baidu.tieba.h.a.a().f()) {
                bsVar4 = this.a.p;
                BdListView B = bsVar4.B();
                bsVar5 = this.a.p;
                com.baidu.tieba.util.ap.a(B, bsVar5.m().a(), this.a.c, null, null, 0, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
