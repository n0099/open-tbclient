package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.g {
    final /* synthetic */ l bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(l lVar) {
        this.bHk = lVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.bHk.Ge;
        if (AntiHelper.rU(xVar.getErrorCode())) {
            Activity pageActivity = this.bHk.aTS.getPageContext().getPageActivity();
            xVar4 = this.bHk.Ge;
            AntiHelper.R(pageActivity, xVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.bHk.bGT;
            str = this.bHk.bGV;
            cVar.dn(!StringUtils.isNull(str));
        } else {
            xVar2 = this.bHk.Ge;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                xVar3 = this.bHk.Ge;
                com.baidu.adp.lib.util.k.showToast(m9getInst, xVar3.getErrorString());
            }
        }
    }
}
