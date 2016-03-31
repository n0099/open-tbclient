package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.g {
    final /* synthetic */ y aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.aSZ = yVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.x) {
            wVar4 = this.aSZ.MY;
            if (wVar4.getErrorCode() == 0) {
                return;
            }
        }
        wVar = this.aSZ.MY;
        if (AntiHelper.pB(wVar.getErrorCode())) {
            Context context = this.aSZ.getContext();
            wVar3 = this.aSZ.MY;
            AntiHelper.O(context, wVar3.getErrorString());
            return;
        }
        TbPageContext<?> Lb = this.aSZ.Lb();
        wVar2 = this.aSZ.MY;
        Lb.showToast(wVar2.getErrorString());
    }
}
