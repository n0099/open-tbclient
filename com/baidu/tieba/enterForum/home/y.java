package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.g {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(i iVar) {
        this.aUE = iVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.aUE.MB;
        if (AntiHelper.ne(xVar.getErrorCode())) {
            Activity pageActivity = this.aUE.aJl.getPageContext().getPageActivity();
            xVar4 = this.aUE.MB;
            AntiHelper.Q(pageActivity, xVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.aUE.aUm;
            str = this.aUE.aUo;
            cVar.cd(!StringUtils.isNull(str));
        } else {
            xVar2 = this.aUE.MB;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                xVar3 = this.aUE.MB;
                com.baidu.adp.lib.util.k.showToast(m411getInst, xVar3.getErrorString());
            }
        }
    }
}
