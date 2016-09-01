package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.g {
    final /* synthetic */ j aYS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aYS = jVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.y) {
            xVar4 = this.aYS.Ge;
            if (xVar4.getErrorCode() == 0) {
                return;
            }
        }
        xVar = this.aYS.Ge;
        if (AntiHelper.rG(xVar.getErrorCode())) {
            Context context = this.aYS.getContext();
            xVar3 = this.aYS.Ge;
            AntiHelper.R(context, xVar3.getErrorString());
            return;
        }
        TbPageContext<?> tbPageContext = this.aYS.getTbPageContext();
        xVar2 = this.aYS.Ge;
        tbPageContext.showToast(xVar2.getErrorString());
    }
}
