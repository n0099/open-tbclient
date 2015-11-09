package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a boK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.boK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotTopicActivity hotTopicActivity;
        MessageManager messageManager = MessageManager.getInstance();
        hotTopicActivity = this.boK.boH;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(hotTopicActivity.getPageContext().getPageActivity())));
    }
}
