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
public class da extends com.baidu.adp.base.g {
    final /* synthetic */ cy bjZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cy cyVar) {
        this.bjZ = cyVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        TbPageContext tbPageContext;
        com.baidu.tieba.tbadkCore.w wVar4;
        wVar = this.bjZ.MS;
        if (AntiHelper.or(wVar.getErrorCode())) {
            tbPageContext = this.bjZ.MR;
            Activity pageActivity = tbPageContext.getPageActivity();
            wVar4 = this.bjZ.MS;
            AntiHelper.X(pageActivity, wVar4.getErrorString());
        } else if (obj == null) {
            wVar2 = this.bjZ.MS;
            if (!StringUtils.isNull(wVar2.getErrorString())) {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                wVar3 = this.bjZ.MS;
                com.baidu.adp.lib.util.k.showToast(m411getInst, wVar3.getErrorString());
            }
        } else {
            com.baidu.tieba.tbadkCore.x xVar = (com.baidu.tieba.tbadkCore.x) obj;
            xVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }
}
