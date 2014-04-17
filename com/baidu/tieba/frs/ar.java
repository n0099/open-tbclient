package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class ar implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        String str;
        String str2;
        g gVar;
        cm cmVar4;
        cm cmVar5;
        com.baidu.tbadk.imageManager.d dVar;
        try {
            cmVar = this.a.r;
            cmVar.u().a().a();
            cmVar2 = this.a.r;
            cmVar2.w().a().a();
            cmVar3 = this.a.r;
            cmVar3.v().a().a();
            str = this.a.J;
            if (!str.equals("frs_page")) {
                str2 = this.a.J;
                if (str2.equals("normal_page")) {
                    gVar = this.a.D;
                    String image_url = gVar.f().getImage_url();
                    if (image_url != null && image_url.length() > 0) {
                        this.a.e();
                    }
                }
            } else {
                this.a.f();
            }
            this.a.l();
            int i = com.baidu.tbadk.core.h.a().f() ? 0 : 1;
            int i2 = com.baidu.tbadk.core.h.a().d() ? 0 : -1;
            cmVar4 = this.a.r;
            BdListView J = cmVar4.J();
            cmVar5 = this.a.r;
            com.baidu.tbadk.editortool.ab a = cmVar5.u().a();
            com.baidu.tbadk.imageManager.d dVar2 = this.a.c;
            dVar = this.a.ac;
            com.baidu.tbadk.core.util.ac.a(J, a, dVar2, dVar, null, i, i2);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
