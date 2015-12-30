package com.baidu.tieba.card;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class k extends com.baidu.adp.base.g {
    final /* synthetic */ h aNI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.aNI = hVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        com.baidu.tieba.tbadkCore.x xVar5;
        xVar = this.aNI.MB;
        if (xVar != null && (obj instanceof com.baidu.tieba.tbadkCore.y)) {
            xVar2 = this.aNI.MB;
            if (!AntiHelper.ne(xVar2.getErrorCode())) {
                xVar3 = this.aNI.MB;
                if (xVar3.getErrorCode() != 0) {
                    TbPageContext<?> Ie = this.aNI.Ie();
                    xVar4 = this.aNI.MB;
                    Ie.showToast(xVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aNI.Ie().getPageActivity();
            xVar5 = this.aNI.MB;
            AntiHelper.Q(pageActivity, xVar5.getErrorString());
        }
    }
}
