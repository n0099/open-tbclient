package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.view.p aUI;
    private final /* synthetic */ long aUJ;
    private final /* synthetic */ String aUK;
    private final /* synthetic */ ShareFromFrsMsgData aUL;
    final /* synthetic */ FrsActivity aUz;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.aUz = frsActivity;
        this.aUI = pVar;
        this.aUJ = j;
        this.val$name = str;
        this.aUK = str2;
        this.aUL = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUz.HidenSoftKeyPad((InputMethodManager) this.aUz.getSystemService("input_method"), this.aUI.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aUz.getPageContext().getPageActivity(), this.aUJ, this.val$name, this.aUK, 0, this.aUI.getLeaveMsg(), this.aUL.toChatMessageContent())));
        aVar.dismiss();
    }
}
