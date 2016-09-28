package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g {
    final /* synthetic */ h aZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.aZm = hVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.y) {
            xVar4 = this.aZm.Ge;
            if (xVar4.getErrorCode() == 0) {
                return;
            }
        }
        xVar = this.aZm.Ge;
        if (AntiHelper.rU(xVar.getErrorCode())) {
            Context context = this.aZm.getContext();
            xVar3 = this.aZm.Ge;
            AntiHelper.R(context, xVar3.getErrorString());
            return;
        }
        TbPageContext<?> tbPageContext = this.aZm.getTbPageContext();
        xVar2 = this.aZm.Ge;
        tbPageContext.showToast(xVar2.getErrorString());
    }
}
