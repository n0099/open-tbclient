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
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.aNz = aVar;
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
        frsActivity = this.aNz.aNb;
        w Ju = frsActivity.Ju();
        if (Ju != null && Ju.YO() != null) {
            String name = Ju.YO().getName();
            if (obj != null && (obj instanceof ah)) {
                com.baidu.tieba.tbadkCore.d.ako().D(name, false);
                ((ah) obj).setLike(1);
                Ju.a((ah) obj);
                z = true;
            }
            frsActivity2 = this.aNz.aNb;
            frsActivity2.aJF.c(Boolean.valueOf(z));
            if (!z) {
                afVar = this.aNz.LO;
                if (afVar.getErrorCode() == 22) {
                    frsActivity4 = this.aNz.aNb;
                    frsActivity4.showToast(this.aNz.getPageContext().getString(y.had_liked_forum));
                    return;
                }
                frsActivity3 = this.aNz.aNb;
                afVar2 = this.aNz.LO;
                frsActivity3.showToast(afVar2.getErrorString());
                return;
            }
            this.aNz.a(Ju, true);
            frsActivity5 = this.aNz.aNb;
            frsActivity5.showToast(this.aNz.getPageContext().getString(y.like_success));
            TbadkCoreApplication.m411getInst().addLikeForum(name);
            this.aNz.f(true, Ju.YO().getId());
        }
    }
}
