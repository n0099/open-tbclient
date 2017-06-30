package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ e bPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.bPN = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.bPN.ajP.getPageActivity(), 23007, 1)));
    }
}
