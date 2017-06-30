package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ e bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bTa = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.bTa.aaG()) {
            if (!TbadkCoreApplication.isLogin()) {
                bl.aM(this.bTa.getPageContext().getPageActivity());
            } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                this.bTa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(this.bTa.getPageContext().getPageActivity())));
            }
        }
    }
}
