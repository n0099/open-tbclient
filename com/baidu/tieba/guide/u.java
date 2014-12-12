package com.baidu.tieba.guide;

import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.i {
    final /* synthetic */ t aNR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aNR = tVar;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        if (obj == null) {
            newUserGuideActivity3 = this.aNR.aNO;
            newUserGuideActivity3.showToast(z.neterror);
        } else if (obj instanceof ae) {
            int i = com.baidu.adp.lib.g.c.toInt(((ae) obj).getFid(), 0);
            aVar = this.aNR.aNP;
            aVar.fl(i);
            this.aNR.n(i, true);
            newUserGuideActivity = this.aNR.aNO;
            newUserGuideActivity.cf(true);
            newUserGuideActivity2 = this.aNR.aNO;
            newUserGuideActivity2.ce(true);
        }
    }
}
