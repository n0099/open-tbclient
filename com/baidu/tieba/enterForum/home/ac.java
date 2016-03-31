package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.g {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(i iVar) {
        this.bbw = iVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.w wVar4;
        wVar = this.bbw.MY;
        if (AntiHelper.pB(wVar.getErrorCode())) {
            Activity pageActivity = this.bbw.aNm.getPageContext().getPageActivity();
            wVar4 = this.bbw.MY;
            AntiHelper.O(pageActivity, wVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.bbw.bbc;
            str = this.bbw.bbe;
            cVar.cn(!StringUtils.isNull(str));
        } else {
            wVar2 = this.bbw.MY;
            if (!StringUtils.isNull(wVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                wVar3 = this.bbw.MY;
                com.baidu.adp.lib.util.k.showToast(m411getInst, wVar3.getErrorString());
            }
        }
    }
}
