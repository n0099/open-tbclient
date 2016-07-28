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
public class ct implements a.b {
    private final /* synthetic */ FrsActivity bHQ;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bHR;
    private final /* synthetic */ long bHS;
    private final /* synthetic */ String bHT;
    private final /* synthetic */ ShareFromFrsMsgData bHU;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bHQ = frsActivity;
        this.bHR = nVar;
        this.bHS = j;
        this.val$name = str;
        this.bHT = str2;
        this.bHU = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bHQ.HidenSoftKeyPad((InputMethodManager) this.bHQ.getSystemService("input_method"), this.bHR.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bHQ.getPageContext().getPageActivity(), this.bHS, this.val$name, this.bHT, 0, this.bHR.getLeaveMsg(), this.bHU.toChatMessageContent())));
        aVar.dismiss();
    }
}
