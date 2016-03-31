package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a.b {
    final /* synthetic */ u bwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.bwT = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.bwT.blH.getPageContext().getPageActivity(), "c10752", "click");
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.bwT.MX.getPageActivity(), this.bwT.mMemberType, "exp_acce", 2);
        memberPayActivityConfig.setSceneId("4004001000");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        aVar.dismiss();
    }
}
