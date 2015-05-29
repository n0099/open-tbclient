package com.baidu.tieba.frs.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.i {
    final /* synthetic */ a aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.aQc = aVar;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        af afVar;
        FrsActivity frsActivity3;
        af afVar2;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        boolean z = false;
        frsActivity = this.aQc.aPE;
        w KE = frsActivity.KE();
        if (KE != null && KE.aar() != null) {
            String name = KE.aar().getName();
            if (obj != null && (obj instanceof ah)) {
                com.baidu.tieba.tbadkCore.d.amo().D(name, false);
                ((ah) obj).setLike(1);
                KE.a((ah) obj);
                z = true;
            }
            frsActivity2 = this.aQc.aPE;
            frsActivity2.aLW.c(Boolean.valueOf(z));
            if (!z) {
                afVar = this.aQc.LI;
                if (afVar.getErrorCode() == 22) {
                    frsActivity4 = this.aQc.aPE;
                    frsActivity4.showToast(this.aQc.getPageContext().getString(t.had_liked_forum));
                    return;
                }
                frsActivity3 = this.aQc.aPE;
                afVar2 = this.aQc.LI;
                frsActivity3.showToast(afVar2.getErrorString());
                return;
            }
            this.aQc.a(KE, true);
            frsActivity5 = this.aQc.aPE;
            frsActivity5.showToast(this.aQc.getPageContext().getString(t.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.aQc.f(true, KE.aar().getId());
        }
    }
}
