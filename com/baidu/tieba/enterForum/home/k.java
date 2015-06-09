package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.i {
    final /* synthetic */ a aFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.aFe = aVar;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        af afVar;
        af afVar2;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        if (obj != null) {
            cVar = this.aFe.aEN;
            str = this.aFe.aEP;
            cVar.bJ(!StringUtils.isNull(str));
            return;
        }
        afVar = this.aFe.LI;
        if (!StringUtils.isNull(afVar.getErrorString())) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            afVar2 = this.aFe.LI;
            com.baidu.adp.lib.util.n.showToast(m411getInst, afVar2.getErrorString());
        }
    }
}
