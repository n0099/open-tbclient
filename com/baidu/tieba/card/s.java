package com.baidu.tieba.card;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g {
    final /* synthetic */ p aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.aTK = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.y yVar;
        com.baidu.tieba.tbadkCore.y yVar2;
        com.baidu.tieba.tbadkCore.y yVar3;
        com.baidu.tieba.tbadkCore.y yVar4;
        if (obj instanceof com.baidu.tieba.tbadkCore.z) {
            yVar4 = this.aTK.DR;
            if (yVar4.getErrorCode() == 0) {
                return;
            }
        }
        yVar = this.aTK.DR;
        if (AntiHelper.rg(yVar.getErrorCode())) {
            Context context = this.aTK.getContext();
            yVar3 = this.aTK.DR;
            AntiHelper.O(context, yVar3.getErrorString());
            return;
        }
        TbPageContext<?> KM = this.aTK.KM();
        yVar2 = this.aTK.DR;
        KM.showToast(yVar2.getErrorString());
    }
}
