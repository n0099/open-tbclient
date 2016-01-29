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
public class s implements a.b {
    final /* synthetic */ o bKu;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.r bKv;
    private final /* synthetic */ ShareFromTopicMsgData bKw;
    private final /* synthetic */ int bgL;
    private final /* synthetic */ String bgM;
    private final /* synthetic */ long bgN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, com.baidu.tieba.hottopic.view.r rVar, int i, String str, long j, ShareFromTopicMsgData shareFromTopicMsgData) {
        this.bKu = oVar;
        this.bKv = rVar;
        this.bgL = i;
        this.bgM = str;
        this.bgN = j;
        this.bKw = shareFromTopicMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.bKu.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bKv.getChatMsgView().getWindowToken(), 2);
        tbPageContext2 = this.bKu.context;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(((HotTopicActivity) tbPageContext2.getOrignalPage()).getPageContext().getPageActivity(), this.bgL, this.bgM, this.bgN, "from_share", this.bKv.getLeaveMsg(), this.bKw.toChatMessageContent())));
        aVar.dismiss();
    }
}
