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
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.aQd = aVar;
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
        frsActivity = this.aQd.aPF;
        w KF = frsActivity.KF();
        if (KF != null && KF.aas() != null) {
            String name = KF.aas().getName();
            if (obj != null && (obj instanceof ah)) {
                com.baidu.tieba.tbadkCore.d.amp().D(name, false);
                ((ah) obj).setLike(1);
                KF.a((ah) obj);
                z = true;
            }
            frsActivity2 = this.aQd.aPF;
            frsActivity2.aLX.c(Boolean.valueOf(z));
            if (!z) {
                afVar = this.aQd.LI;
                if (afVar.getErrorCode() == 22) {
                    frsActivity4 = this.aQd.aPF;
                    frsActivity4.showToast(this.aQd.getPageContext().getString(t.had_liked_forum));
                    return;
                }
                frsActivity3 = this.aQd.aPF;
                afVar2 = this.aQd.LI;
                frsActivity3.showToast(afVar2.getErrorString());
                return;
            }
            this.aQd.a(KF, true);
            frsActivity5 = this.aQd.aPF;
            frsActivity5.showToast(this.aQd.getPageContext().getString(t.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.aQd.f(true, KF.aas().getId());
        }
    }
}
