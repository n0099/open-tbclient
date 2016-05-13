package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g {
    final /* synthetic */ p aPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.aPs = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.y) {
            xVar4 = this.aPs.Dp;
            if (xVar4.getErrorCode() == 0) {
                return;
            }
        }
        xVar = this.aPs.Dp;
        if (AntiHelper.pv(xVar.getErrorCode())) {
            Context context = this.aPs.getContext();
            xVar3 = this.aPs.Dp;
            AntiHelper.O(context, xVar3.getErrorString());
            return;
        }
        TbPageContext<?> tbPageContext = this.aPs.getTbPageContext();
        xVar2 = this.aPs.Dp;
        tbPageContext.showToast(xVar2.getErrorString());
    }
}
