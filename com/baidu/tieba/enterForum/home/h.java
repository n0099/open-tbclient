package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bh;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ e bMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bMz = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.bMz.Xj()) {
            if (!TbadkCoreApplication.isLogin()) {
                bh.aM(this.bMz.getPageContext().getPageActivity());
            } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                this.bMz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(this.bMz.getPageContext().getPageActivity())));
            }
        }
    }
}
