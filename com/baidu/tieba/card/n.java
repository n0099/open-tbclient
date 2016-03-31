package com.baidu.tieba.card;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.g {
    final /* synthetic */ k aRZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.aRZ = kVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        wVar = this.aRZ.MY;
        if (wVar != null && (obj instanceof com.baidu.tieba.tbadkCore.x)) {
            wVar2 = this.aRZ.MY;
            if (!AntiHelper.pB(wVar2.getErrorCode())) {
                wVar3 = this.aRZ.MY;
                if (wVar3.getErrorCode() != 0) {
                    TbPageContext<?> Lb = this.aRZ.Lb();
                    wVar4 = this.aRZ.MY;
                    Lb.showToast(wVar4.getErrorString());
                    return;
                }
                return;
            }
            Activity pageActivity = this.aRZ.Lb().getPageActivity();
            wVar5 = this.aRZ.MY;
            AntiHelper.O(pageActivity, wVar5.getErrorString());
        }
    }
}
