package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.g {
    final /* synthetic */ d aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(d dVar) {
        this.aMD = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.v vVar;
        com.baidu.tieba.tbadkCore.v vVar2;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        if (obj != null) {
            cVar = this.aMD.aMn;
            str = this.aMD.aMp;
            cVar.bL(!StringUtils.isNull(str));
            return;
        }
        vVar = this.aMD.LT;
        if (!StringUtils.isNull(vVar.getErrorString())) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            vVar2 = this.aMD.LT;
            com.baidu.adp.lib.util.k.showToast(m411getInst, vVar2.getErrorString());
        }
    }
}
