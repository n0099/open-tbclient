package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aHR;
    private final /* synthetic */ String bFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str) {
        this.aHR = tbPageContext;
        this.bFd = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.aHR.getPageActivity(), 23007)));
        TiebaStatic.log(new as("c10125").Z("fid", this.bFd).s("obj_type", 1));
    }
}
