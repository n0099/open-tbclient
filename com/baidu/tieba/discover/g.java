package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ d bJp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bJp = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(this.bJp.ajh.getPageActivity(), 23007, 1)));
    }
}
