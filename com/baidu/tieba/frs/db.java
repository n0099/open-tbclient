package com.baidu.tieba.frs;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db extends com.baidu.adp.base.g {
    final /* synthetic */ cz bkB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cz czVar) {
        this.bkB = czVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        TbPageContext tbPageContext;
        com.baidu.tieba.tbadkCore.x xVar4;
        xVar = this.bkB.Dp;
        if (AntiHelper.pw(xVar.getErrorCode())) {
            tbPageContext = this.bkB.Do;
            Activity pageActivity = tbPageContext.getPageActivity();
            xVar4 = this.bkB.Dp;
            AntiHelper.O(pageActivity, xVar4.getErrorString());
        } else if (obj == null) {
            xVar2 = this.bkB.Dp;
            if (!StringUtils.isNull(xVar2.getErrorString())) {
                TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                xVar3 = this.bkB.Dp;
                com.baidu.adp.lib.util.k.showToast(m11getInst, xVar3.getErrorString());
            }
        } else {
            com.baidu.tieba.tbadkCore.y yVar = (com.baidu.tieba.tbadkCore.y) obj;
            yVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }
}
