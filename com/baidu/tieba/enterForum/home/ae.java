package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.g {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(l lVar) {
        this.bHc = lVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.bHc.Ge;
        if (AntiHelper.rG(xVar.getErrorCode())) {
            Activity pageActivity = this.bHc.aTi.getPageContext().getPageActivity();
            xVar4 = this.bHc.Ge;
            AntiHelper.R(pageActivity, xVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.bHc.bGK;
            str = this.bHc.bGM;
            cVar.dm(!StringUtils.isNull(str));
        } else {
            xVar2 = this.bHc.Ge;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                xVar3 = this.bHc.Ge;
                com.baidu.adp.lib.util.k.showToast(m9getInst, xVar3.getErrorString());
            }
        }
    }
}
