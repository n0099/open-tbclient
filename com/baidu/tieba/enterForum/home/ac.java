package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.g {
    final /* synthetic */ i aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(i iVar) {
        this.aWN = iVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.w wVar4;
        wVar = this.aWN.MS;
        if (AntiHelper.or(wVar.getErrorCode())) {
            Activity pageActivity = this.aWN.aKq.getPageContext().getPageActivity();
            wVar4 = this.aWN.MS;
            AntiHelper.X(pageActivity, wVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.aWN.aWt;
            str = this.aWN.aWv;
            cVar.cb(!StringUtils.isNull(str));
        } else {
            wVar2 = this.aWN.MS;
            if (!StringUtils.isNull(wVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                wVar3 = this.aWN.MS;
                com.baidu.adp.lib.util.k.showToast(m411getInst, wVar3.getErrorString());
            }
        }
    }
}
