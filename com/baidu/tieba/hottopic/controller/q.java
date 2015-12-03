package com.baidu.tieba.hottopic.controller;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.b {
    final /* synthetic */ k bDq;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.j bDr;
    private final /* synthetic */ ShareFromTopicMsgData bDs;
    private final /* synthetic */ long bao;
    private final /* synthetic */ String bap;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar, com.baidu.tieba.hottopic.view.j jVar, long j, String str, String str2, ShareFromTopicMsgData shareFromTopicMsgData) {
        this.bDq = kVar;
        this.bDr = jVar;
        this.bao = j;
        this.val$name = str;
        this.bap = str2;
        this.bDs = shareFromTopicMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.bDq.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bDr.getChatMsgView().getWindowToken(), 2);
        tbPageContext2 = this.bDq.context;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(((HotTopicActivity) tbPageContext2.getOrignalPage()).getPageContext().getPageActivity(), this.bao, this.val$name, this.bap, 0, this.bDr.getLeaveMsg(), this.bDs.toChatMessageContent())));
        aVar.dismiss();
    }
}
