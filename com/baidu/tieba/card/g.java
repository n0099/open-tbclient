package com.baidu.tieba.card;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.g {
    final /* synthetic */ d aNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.aNF = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        com.baidu.tieba.tbadkCore.x xVar5;
        xVar = this.aNF.MB;
        if (xVar != null && (obj instanceof com.baidu.tieba.tbadkCore.y)) {
            xVar2 = this.aNF.MB;
            if (!AntiHelper.ne(xVar2.getErrorCode())) {
                xVar3 = this.aNF.MB;
                if (xVar3.getErrorCode() != 0) {
                    TbPageContext<?> Ie = this.aNF.Ie();
                    xVar4 = this.aNF.MB;
                    Ie.showToast(xVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aNF.Ie().getPageActivity();
            xVar5 = this.aNF.MB;
            AntiHelper.Q(pageActivity, xVar5.getErrorString());
        }
    }
}
