package com.baidu.tieba.card;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.g {
    final /* synthetic */ k aPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.aPj = kVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        wVar = this.aPj.MS;
        if (wVar != null && (obj instanceof com.baidu.tieba.tbadkCore.x)) {
            wVar2 = this.aPj.MS;
            if (!AntiHelper.or(wVar2.getErrorCode())) {
                wVar3 = this.aPj.MS;
                if (wVar3.getErrorCode() != 0) {
                    TbPageContext<?> JK = this.aPj.JK();
                    wVar4 = this.aPj.MS;
                    JK.showToast(wVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aPj.JK().getPageActivity();
            wVar5 = this.aPj.MS;
            AntiHelper.X(pageActivity, wVar5.getErrorString());
        }
    }
}
