package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g {
    final /* synthetic */ p aSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.aSO = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.y yVar;
        com.baidu.tieba.tbadkCore.y yVar2;
        com.baidu.tieba.tbadkCore.y yVar3;
        com.baidu.tieba.tbadkCore.y yVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.z) {
            yVar4 = this.aSO.Dq;
            if (yVar4.getErrorCode() == 0) {
                return;
            }
        }
        yVar = this.aSO.Dq;
        if (AntiHelper.qL(yVar.getErrorCode())) {
            Context context = this.aSO.getContext();
            yVar3 = this.aSO.Dq;
            AntiHelper.O(context, yVar3.getErrorString());
            return;
        }
        TbPageContext<?> KN = this.aSO.KN();
        yVar2 = this.aSO.Dq;
        KN.showToast(yVar2.getErrorString());
    }
}
