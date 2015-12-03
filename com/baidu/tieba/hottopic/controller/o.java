package com.baidu.tieba.hottopic.controller;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ k bDq;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.j bDr;
    private final /* synthetic */ ShareFromTopicMsgData bDs;
    private final /* synthetic */ int bas;
    private final /* synthetic */ String bat;
    private final /* synthetic */ long bau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, com.baidu.tieba.hottopic.view.j jVar, int i, String str, long j, ShareFromTopicMsgData shareFromTopicMsgData) {
        this.bDq = kVar;
        this.bDr = jVar;
        this.bas = i;
        this.bat = str;
        this.bau = j;
        this.bDs = shareFromTopicMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.bDq.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bDr.getChatMsgView().getWindowToken(), 2);
        tbPageContext2 = this.bDq.context;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(((HotTopicActivity) tbPageContext2.getOrignalPage()).getPageContext().getPageActivity(), this.bas, this.bat, this.bau, "from_share", this.bDr.getLeaveMsg(), this.bDs.toChatMessageContent())));
        aVar.dismiss();
    }
}
