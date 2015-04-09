package com.baidu.tieba.frs.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.i {
    final /* synthetic */ a aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.aNQ = aVar;
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
        frsActivity = this.aNQ.aNs;
        w JA = frsActivity.JA();
        if (JA != null && JA.Za() != null) {
            String name = JA.Za().getName();
            if (obj != null && (obj instanceof ah)) {
                com.baidu.tieba.tbadkCore.d.akD().D(name, false);
                ((ah) obj).setLike(1);
                JA.a((ah) obj);
                z = true;
            }
            frsActivity2 = this.aNQ.aNs;
            frsActivity2.aJP.c(Boolean.valueOf(z));
            if (!z) {
                afVar = this.aNQ.LQ;
                if (afVar.getErrorCode() == 22) {
                    frsActivity4 = this.aNQ.aNs;
                    frsActivity4.showToast(this.aNQ.getPageContext().getString(y.had_liked_forum));
                    return;
                }
                frsActivity3 = this.aNQ.aNs;
                afVar2 = this.aNQ.LQ;
                frsActivity3.showToast(afVar2.getErrorString());
                return;
            }
            this.aNQ.a(JA, true);
            frsActivity5 = this.aNQ.aNs;
            frsActivity5.showToast(this.aNQ.getPageContext().getString(y.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.aNQ.f(true, JA.Za().getId());
        }
    }
}
