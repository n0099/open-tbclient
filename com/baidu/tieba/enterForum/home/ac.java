package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.g {
    final /* synthetic */ l bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(l lVar) {
        this.bKe = lVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.bKe.Gg;
        if (AntiHelper.sm(xVar.getErrorCode())) {
            Activity pageActivity = this.bKe.aWd.getPageContext().getPageActivity();
            xVar4 = this.bKe.Gg;
            AntiHelper.S(pageActivity, xVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.bKe.bJN;
            str = this.bKe.bJP;
            cVar.ds(!StringUtils.isNull(str));
        } else {
            xVar2 = this.bKe.Gg;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                xVar3 = this.bKe.Gg;
                com.baidu.adp.lib.util.k.showToast(m9getInst, xVar3.getErrorString());
            }
        }
    }
}
