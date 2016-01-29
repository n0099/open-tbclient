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
public class u implements a.b {
    final /* synthetic */ o bKu;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.r bKv;
    private final /* synthetic */ ShareFromTopicMsgData bKw;
    private final /* synthetic */ long bgI;
    private final /* synthetic */ String bgJ;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar, com.baidu.tieba.hottopic.view.r rVar, long j, String str, String str2, ShareFromTopicMsgData shareFromTopicMsgData) {
        this.bKu = oVar;
        this.bKv = rVar;
        this.bgI = j;
        this.val$name = str;
        this.bgJ = str2;
        this.bKw = shareFromTopicMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.bKu.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bKv.getChatMsgView().getWindowToken(), 2);
        tbPageContext2 = this.bKu.context;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(((HotTopicActivity) tbPageContext2.getOrignalPage()).getPageContext().getPageActivity(), this.bgI, this.val$name, this.bgJ, 0, this.bKv.getLeaveMsg(), this.bKw.toChatMessageContent())));
        aVar.dismiss();
    }
}
