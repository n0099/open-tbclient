package com.baidu.tieba.a;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class j extends com.baidu.adp.base.g {
    final /* synthetic */ g aMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aMh = gVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        xVar = this.aMh.Ml;
        if (xVar != null && (obj instanceof y)) {
            xVar2 = this.aMh.Ml;
            if (!AntiHelper.mC(xVar2.getErrorCode())) {
                xVar3 = this.aMh.Ml;
                if (xVar3.getErrorCode() != 0) {
                    TbPageContext<?> Io = this.aMh.Io();
                    xVar4 = this.aMh.Ml;
                    Io.showToast(xVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aMh.Io().getPageActivity();
            xVar5 = this.aMh.Ml;
            AntiHelper.Q(pageActivity, xVar5.getErrorString());
        }
    }
}
