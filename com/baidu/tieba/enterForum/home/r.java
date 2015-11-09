package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.g {
    final /* synthetic */ d aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(d dVar) {
        this.aMe = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.w wVar4;
        wVar = this.aMe.LU;
        if (AntiHelper.lr(wVar.getErrorCode())) {
            Activity pageActivity = this.aMe.getPageContext().getPageActivity();
            wVar4 = this.aMe.LU;
            AntiHelper.Q(pageActivity, wVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.aMe.aLO;
            str = this.aMe.aLQ;
            cVar.bP(!StringUtils.isNull(str));
        } else {
            wVar2 = this.aMe.LU;
            if (!StringUtils.isNull(wVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                wVar3 = this.aMe.LU;
                com.baidu.adp.lib.util.k.showToast(m411getInst, wVar3.getErrorString());
            }
        }
    }
}
