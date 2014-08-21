package com.baidu.tieba.frs;

import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements Runnable {
    final /* synthetic */ cv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cv cvVar) {
        this.a = cvVar;
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
        dVar = this.a.ap;
        if (dVar != null) {
            dVar2 = this.a.ap;
            dVar2.a();
        }
        if (!com.baidu.tbadk.h.a().a(FrsActivity.b, false)) {
            i = this.a.an;
            if (i == 1) {
                str = this.a.V;
                if (str == "frs_page") {
                    nVar = this.a.B;
                    if (nVar != null) {
                        nVar2 = this.a.B;
                        if (nVar2.c()) {
                            com.baidu.tbadk.h.a().b(FrsActivity.b, true);
                            this.a.d();
                            return;
                        }
                        return;
                    }
                    return;
                }
                str2 = this.a.V;
                if (str2 == "normal_page") {
                    frsHeaderView = this.a.A;
                    if (frsHeaderView != null) {
                        frsHeaderView2 = this.a.A;
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
