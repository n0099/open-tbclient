package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.g {
    final /* synthetic */ h aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(h hVar) {
        this.aQN = hVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.aQN.Ml;
        if (AntiHelper.mC(xVar.getErrorCode())) {
            Activity pageActivity = this.aQN.aHN.getPageContext().getPageActivity();
            xVar4 = this.aQN.Ml;
            AntiHelper.Q(pageActivity, xVar4.getErrorString());
        } else if (obj != null) {
            cVar = this.aQN.aQv;
            str = this.aQN.aQx;
            cVar.cc(!StringUtils.isNull(str));
        } else {
            xVar2 = this.aQN.Ml;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                xVar3 = this.aQN.Ml;
                com.baidu.adp.lib.util.k.showToast(m411getInst, xVar3.getErrorString());
            }
        }
    }
}
