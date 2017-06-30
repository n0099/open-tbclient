package com.baidu.tieba.frs.entelechy;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ c cfN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cfN = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        int i;
        tbPageContext = this.cfN.aat;
        Activity pageActivity = tbPageContext.getPageActivity();
        i = this.cfN.mMemberType;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(pageActivity, i, "exp_acce", 2);
        memberPayActivityConfig.setSceneId("4004001000");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        aVar.dismiss();
    }
}
