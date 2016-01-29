package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    final /* synthetic */ t brL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar) {
        this.brL = tVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.brL.bgW.getPageContext().getPageActivity(), "c10752", "click");
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.brL.MR.getPageActivity(), this.brL.mMemberType, "exp_acce", 2);
        memberPayActivityConfig.setSceneId("4004001000");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        aVar.dismiss();
    }
}
