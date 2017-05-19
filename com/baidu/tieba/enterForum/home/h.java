package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ e bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bGL = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.bGL.Wg()) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.aL(this.bGL.getPageContext().getPageActivity());
            } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                this.bGL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(this.bGL.getPageContext().getPageActivity())));
            }
        }
    }
}
