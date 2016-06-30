package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.g {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(k kVar) {
        this.btA = kVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.y yVar;
        com.baidu.tieba.tbadkCore.y yVar2;
        com.baidu.tieba.tbadkCore.y yVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.y yVar4;
        yVar = this.btA.Dq;
        if (AntiHelper.qL(yVar.getErrorCode())) {
            Activity pageActivity = this.btA.aMU.getPageContext().getPageActivity();
            yVar4 = this.btA.Dq;
            AntiHelper.O(pageActivity, yVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.btA.bth;
            str = this.btA.btj;
            cVar.cP(!StringUtils.isNull(str));
        } else {
            yVar2 = this.btA.Dq;
            if (!StringUtils.isNull(yVar2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                yVar3 = this.btA.Dq;
                com.baidu.adp.lib.util.k.showToast(m9getInst, yVar3.getErrorString());
            }
        }
    }
}
