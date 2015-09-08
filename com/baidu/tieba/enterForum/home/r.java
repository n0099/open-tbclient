package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.g {
    final /* synthetic */ d aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(d dVar) {
        this.aMQ = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        if (obj != null) {
            cVar = this.aMQ.aMA;
            str = this.aMQ.aMC;
            cVar.bQ(!StringUtils.isNull(str));
            return;
        }
        wVar = this.aMQ.LS;
        if (!StringUtils.isNull(wVar.getErrorString())) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            wVar2 = this.aMQ.LS;
            com.baidu.adp.lib.util.k.showToast(m411getInst, wVar2.getErrorString());
        }
    }
}
