package com.baidu.tieba.frs.utils;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class m implements a.b {
    private final /* synthetic */ long bDw;
    private final /* synthetic */ String bDx;
    private final /* synthetic */ FrsActivity bOc;
    private final /* synthetic */ com.baidu.tieba.frs.view.o bOd;
    private final /* synthetic */ ShareFromFrsMsgData bOe;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bOc = frsActivity;
        this.bOd = oVar;
        this.bDw = j;
        this.val$name = str;
        this.bDx = str2;
        this.bOe = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bOc.HidenSoftKeyPad((InputMethodManager) this.bOc.getSystemService("input_method"), this.bOd.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bOc.getPageContext().getPageActivity(), this.bDw, this.val$name, this.bDx, 0, this.bOd.getLeaveMsg(), this.bOe.toChatMessageContent())));
        aVar.dismiss();
    }
}
