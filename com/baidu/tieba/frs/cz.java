package com.baidu.tieba.frs;

import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements Runnable {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cu cuVar) {
        this.a = cuVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        int i;
        String str;
        String str2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        com.baidu.tieba.frs.view.n nVar;
        com.baidu.tieba.frs.view.n nVar2;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.a.ao;
        if (dVar != null) {
            dVar2 = this.a.ao;
            dVar2.a();
        }
        if (!com.baidu.tbadk.h.a().a(FrsActivity.b, false)) {
            i = this.a.am;
            if (i == 1) {
                str = this.a.U;
                if (str == "frs_page") {
                    nVar = this.a.A;
                    if (nVar != null) {
                        nVar2 = this.a.A;
                        if (nVar2.c()) {
                            com.baidu.tbadk.h.a().b(FrsActivity.b, true);
                            this.a.d();
                            return;
                        }
                        return;
                    }
                    return;
                }
                str2 = this.a.U;
                if (str2 == "normal_page") {
                    frsHeaderView = this.a.z;
                    if (frsHeaderView != null) {
                        frsHeaderView2 = this.a.z;
                        if (frsHeaderView2.a()) {
                            com.baidu.tbadk.h.a().b(FrsActivity.b, true);
                            this.a.d();
                        }
                    }
                }
            }
        }
    }
}
