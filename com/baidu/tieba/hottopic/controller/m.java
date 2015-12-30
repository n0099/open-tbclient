package com.baidu.tieba.hottopic.controller;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k bGU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.bGU = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.bGU.context;
        tbPageContext.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        tbPageContext2 = this.bGU.context;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(((HotTopicActivity) tbPageContext2.getOrignalPage()).getPageContext().getPageActivity(), 23007)));
    }
}
