package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g {
    final /* synthetic */ p aOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.aOb = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.y) {
            xVar4 = this.aOb.MB;
            if (xVar4.getErrorCode() == 0) {
                return;
            }
        }
        xVar = this.aOb.MB;
        if (AntiHelper.ne(xVar.getErrorCode())) {
            Context context = this.aOb.getContext();
            xVar3 = this.aOb.MB;
            AntiHelper.Q(context, xVar3.getErrorString());
            return;
        }
        TbPageContext<?> Ie = this.aOb.Ie();
        xVar2 = this.aOb.MB;
        Ie.showToast(xVar2.getErrorString());
    }
}
