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
class n implements a.b {
    private final /* synthetic */ long bXm;
    private final /* synthetic */ String bXn;
    private final /* synthetic */ FrsActivity ciV;
    private final /* synthetic */ com.baidu.tieba.frs.view.o ciW;
    private final /* synthetic */ ShareFromFrsMsgData ciX;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ciV = frsActivity;
        this.ciW = oVar;
        this.bXm = j;
        this.val$name = str;
        this.bXn = str2;
        this.ciX = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciV.HidenSoftKeyPad((InputMethodManager) this.ciV.getSystemService("input_method"), this.ciW.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ciV.getPageContext().getPageActivity(), this.bXm, this.val$name, this.bXn, 0, this.ciW.getLeaveMsg(), this.ciX.toChatMessageContent())));
        aVar.dismiss();
    }
}
