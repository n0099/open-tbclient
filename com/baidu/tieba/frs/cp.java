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
public class cp implements a.b {
    private final /* synthetic */ FrsActivity bSP;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bSQ;
    private final /* synthetic */ long bSR;
    private final /* synthetic */ String bSS;
    private final /* synthetic */ ShareFromFrsMsgData bST;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bSP = frsActivity;
        this.bSQ = nVar;
        this.bSR = j;
        this.val$name = str;
        this.bSS = str2;
        this.bST = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(a aVar) {
        this.bSP.HidenSoftKeyPad((InputMethodManager) this.bSP.getSystemService("input_method"), this.bSQ.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bSP.getPageContext().getPageActivity(), this.bSR, this.val$name, this.bSS, 0, this.bSQ.getLeaveMsg(), this.bST.toChatMessageContent())));
        aVar.dismiss();
    }
}
