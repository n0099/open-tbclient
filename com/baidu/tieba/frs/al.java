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
public class al implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.view.p aUI;
    private final /* synthetic */ ShareFromFrsMsgData aUL;
    private final /* synthetic */ int aUM;
    private final /* synthetic */ String aUN;
    private final /* synthetic */ long aUO;
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.aUz = frsActivity;
        this.aUI = pVar;
        this.aUM = i;
        this.aUN = str;
        this.aUO = j;
        this.aUL = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUz.HidenSoftKeyPad((InputMethodManager) this.aUz.getSystemService("input_method"), this.aUI.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.aUz.getPageContext().getPageActivity(), this.aUM, this.aUN, this.aUO, "from_share", this.aUI.getLeaveMsg(), this.aUL.toChatMessageContent())));
        aVar.dismiss();
    }
}
