package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ FrsActivity bag;
    private final /* synthetic */ com.baidu.tieba.frs.view.p ban;
    private final /* synthetic */ ShareFromFrsMsgData baq;
    private final /* synthetic */ int bas;
    private final /* synthetic */ String bat;
    private final /* synthetic */ long bau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bag = frsActivity;
        this.ban = pVar;
        this.bas = i;
        this.bat = str;
        this.bau = j;
        this.baq = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bag.HidenSoftKeyPad((InputMethodManager) this.bag.getSystemService("input_method"), this.ban.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bag.getPageContext().getPageActivity(), this.bas, this.bat, this.bau, "from_share", this.ban.getLeaveMsg(), this.baq.toChatMessageContent())));
        aVar.dismiss();
    }
}
