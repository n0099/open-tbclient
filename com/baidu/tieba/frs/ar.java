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
            cmVar.t().a().a();
            cmVar2 = this.a.r;
            cmVar2.v().a().a();
            cmVar3 = this.a.r;
            cmVar3.u().a().a();
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
            cmVar4 = this.a.r;
            BdListView I = cmVar4.I();
            cmVar5 = this.a.r;
            com.baidu.tbadk.editortool.aa a = cmVar5.t().a();
            com.baidu.tbadk.imageManager.d dVar2 = this.a.c;
            dVar = this.a.ac;
            com.baidu.tbadk.core.util.ac.a(I, a, dVar2, dVar, null, i, 0);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FrsActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
