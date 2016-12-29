package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.g {
    final /* synthetic */ l bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(l lVar) {
        this.bqi = lVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.w wVar4;
        wVar = this.bqi.Gg;
        if (AntiHelper.rp(wVar.getErrorCode())) {
            Activity pageActivity = this.bqi.aVu.getPageContext().getPageActivity();
            wVar4 = this.bqi.Gg;
            AntiHelper.S(pageActivity, wVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.bqi.bpR;
            str = this.bqi.bpT;
            cVar.da(!StringUtils.isNull(str));
        } else {
            wVar2 = this.bqi.Gg;
            if (!StringUtils.isNull(wVar2.getErrorString())) {
                TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                wVar3 = this.bqi.Gg;
                com.baidu.adp.lib.util.k.showToast(m9getInst, wVar3.getErrorString());
            }
        }
    }
}
