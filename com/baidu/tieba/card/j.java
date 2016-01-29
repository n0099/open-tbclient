package com.baidu.tieba.card;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class j extends com.baidu.adp.base.g {
    final /* synthetic */ g aPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aPg = gVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        wVar = this.aPg.MS;
        if (wVar != null && (obj instanceof com.baidu.tieba.tbadkCore.x)) {
            wVar2 = this.aPg.MS;
            if (!AntiHelper.or(wVar2.getErrorCode())) {
                wVar3 = this.aPg.MS;
                if (wVar3.getErrorCode() != 0) {
                    TbPageContext<?> JK = this.aPg.JK();
                    wVar4 = this.aPg.MS;
                    JK.showToast(wVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aPg.JK().getPageActivity();
            wVar5 = this.aPg.MS;
            AntiHelper.X(pageActivity, wVar5.getErrorString());
        }
    }
}
