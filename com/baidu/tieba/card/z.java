package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.g {
    final /* synthetic */ w aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.aQe = wVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.x) {
            wVar4 = this.aQe.MS;
            if (wVar4.getErrorCode() == 0) {
                return;
            }
        }
        wVar = this.aQe.MS;
        if (AntiHelper.or(wVar.getErrorCode())) {
            Context context = this.aQe.getContext();
            wVar3 = this.aQe.MS;
            AntiHelper.X(context, wVar3.getErrorString());
            return;
        }
        TbPageContext<?> JK = this.aQe.JK();
        wVar2 = this.aQe.MS;
        JK.showToast(wVar2.getErrorString());
    }
}
