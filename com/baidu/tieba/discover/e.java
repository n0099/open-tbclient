package com.baidu.tieba.discover;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ a aJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.aJA = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        TbadkApplication.getInst().setLocationShared(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_NEIGHBORS, new IntentConfig(this.aJA.getPageContext().getPageActivity())));
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        this.aJA.sendMessage(httpMessage);
    }
}
