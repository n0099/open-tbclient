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
    final /* synthetic */ k bGU;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.j bGV;
    private final /* synthetic */ ShareFromTopicMsgData bGW;
    private final /* synthetic */ long ben;
    private final /* synthetic */ String beo;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar, com.baidu.tieba.hottopic.view.j jVar, long j, String str, String str2, ShareFromTopicMsgData shareFromTopicMsgData) {
        this.bGU = kVar;
        this.bGV = jVar;
        this.ben = j;
        this.val$name = str;
        this.beo = str2;
        this.bGW = shareFromTopicMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.bGU.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bGV.getChatMsgView().getWindowToken(), 2);
        tbPageContext2 = this.bGU.context;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(((HotTopicActivity) tbPageContext2.getOrignalPage()).getPageContext().getPageActivity(), this.ben, this.val$name, this.beo, 0, this.bGV.getLeaveMsg(), this.bGW.toChatMessageContent())));
        aVar.dismiss();
    }
}
