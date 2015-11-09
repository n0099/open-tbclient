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
    final /* synthetic */ FrsActivity aUS;
    private final /* synthetic */ com.baidu.tieba.frs.view.p aVb;
    private final /* synthetic */ long aVc;
    private final /* synthetic */ String aVd;
    private final /* synthetic */ ShareFromFrsMsgData aVe;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.aUS = frsActivity;
        this.aVb = pVar;
        this.aVc = j;
        this.val$name = str;
        this.aVd = str2;
        this.aVe = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUS.HidenSoftKeyPad((InputMethodManager) this.aUS.getSystemService("input_method"), this.aVb.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aUS.getPageContext().getPageActivity(), this.aVc, this.val$name, this.aVd, 0, this.aVb.getLeaveMsg(), this.aVe.toChatMessageContent())));
        aVar.dismiss();
    }
}
