package com.baidu.tieba.a;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.g {
    final /* synthetic */ c aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.aMe = cVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        xVar = this.aMe.Ml;
        if (xVar != null && (obj instanceof y)) {
            xVar2 = this.aMe.Ml;
            if (!AntiHelper.mC(xVar2.getErrorCode())) {
                xVar3 = this.aMe.Ml;
                if (xVar3.getErrorCode() != 0) {
                    TbPageContext<?> Io = this.aMe.Io();
                    xVar4 = this.aMe.Ml;
                    Io.showToast(xVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aMe.Io().getPageActivity();
            xVar5 = this.aMe.Ml;
            AntiHelper.Q(pageActivity, xVar5.getErrorString());
        }
    }
}
