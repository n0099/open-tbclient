package com.baidu.tieba.card;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class j extends com.baidu.adp.base.g {
    final /* synthetic */ g aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aRW = gVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        wVar = this.aRW.MY;
        if (wVar != null && (obj instanceof com.baidu.tieba.tbadkCore.x)) {
            wVar2 = this.aRW.MY;
            if (!AntiHelper.pB(wVar2.getErrorCode())) {
                wVar3 = this.aRW.MY;
                if (wVar3.getErrorCode() != 0) {
                    TbPageContext<?> Lb = this.aRW.Lb();
                    wVar4 = this.aRW.MY;
                    Lb.showToast(wVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aRW.Lb().getPageActivity();
            wVar5 = this.aRW.MY;
            AntiHelper.O(pageActivity, wVar5.getErrorString());
        }
    }
}
