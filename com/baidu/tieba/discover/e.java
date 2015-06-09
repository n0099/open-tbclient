package com.baidu.tieba.discover;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.aDT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkApplication.getInst().setLocationShared(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2902001, new com.baidu.tbadk.core.frameworkData.c(this.aDT.getPageContext().getPageActivity())));
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        this.aDT.sendMessage(httpMessage);
    }
}
