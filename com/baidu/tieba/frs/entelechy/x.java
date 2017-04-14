package com.baidu.tieba.frs.entelechy;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ t bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bRF = tVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        TbPageContext tbPageContext;
        int i;
        frsActivity = this.bRF.bOf;
        TiebaStatic.eventStat(frsActivity.getPageContext().getPageActivity(), "c10752", "click");
        tbPageContext = this.bRF.aaX;
        Activity pageActivity = tbPageContext.getPageActivity();
        i = this.bRF.mMemberType;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(pageActivity, i, "exp_acce", 2);
        memberPayActivityConfig.setSceneId("4004001000");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        aVar.dismiss();
    }
}
