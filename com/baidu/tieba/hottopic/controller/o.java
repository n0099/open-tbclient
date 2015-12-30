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
    final /* synthetic */ k bGU;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.j bGV;
    private final /* synthetic */ ShareFromTopicMsgData bGW;
    private final /* synthetic */ int beq;
    private final /* synthetic */ String ber;
    private final /* synthetic */ long bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, com.baidu.tieba.hottopic.view.j jVar, int i, String str, long j, ShareFromTopicMsgData shareFromTopicMsgData) {
        this.bGU = kVar;
        this.bGV = jVar;
        this.beq = i;
        this.ber = str;
        this.bes = j;
        this.bGW = shareFromTopicMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.bGU.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bGV.getChatMsgView().getWindowToken(), 2);
        tbPageContext2 = this.bGU.context;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(((HotTopicActivity) tbPageContext2.getOrignalPage()).getPageContext().getPageActivity(), this.beq, this.ber, this.bes, "from_share", this.bGV.getLeaveMsg(), this.bGW.toChatMessageContent())));
        aVar.dismiss();
    }
}
