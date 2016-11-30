package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g {
    final /* synthetic */ h bcv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bcv = hVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.y) {
            xVar4 = this.bcv.Gg;
            if (xVar4.getErrorCode() == 0) {
                return;
            }
        }
        xVar = this.bcv.Gg;
        if (AntiHelper.sm(xVar.getErrorCode())) {
            Context context = this.bcv.getContext();
            xVar3 = this.bcv.Gg;
            AntiHelper.S(context, xVar3.getErrorString());
            return;
        }
        TbPageContext<?> tbPageContext = this.bcv.getTbPageContext();
        xVar2 = this.bcv.Gg;
        tbPageContext.showToast(xVar2.getErrorString());
    }
}
