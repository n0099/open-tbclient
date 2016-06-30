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
public class j implements a.b {
    final /* synthetic */ d bIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.bIu = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        int i;
        tbPageContext = this.bIu.Dp;
        Activity pageActivity = tbPageContext.getPageActivity();
        i = this.bIu.mMemberType;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(pageActivity, i, "exp_acce", 2);
        memberPayActivityConfig.setSceneId("4004001000");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        aVar.dismiss();
    }
}
