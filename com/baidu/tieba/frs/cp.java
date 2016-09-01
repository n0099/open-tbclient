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
    private final /* synthetic */ FrsActivity bSW;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bSX;
    private final /* synthetic */ long bSY;
    private final /* synthetic */ String bSZ;
    private final /* synthetic */ ShareFromFrsMsgData bTa;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bSW = frsActivity;
        this.bSX = nVar;
        this.bSY = j;
        this.val$name = str;
        this.bSZ = str2;
        this.bTa = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(a aVar) {
        this.bSW.HidenSoftKeyPad((InputMethodManager) this.bSW.getSystemService("input_method"), this.bSX.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bSW.getPageContext().getPageActivity(), this.bSY, this.val$name, this.bSZ, 0, this.bSX.getLeaveMsg(), this.bTa.toChatMessageContent())));
        aVar.dismiss();
    }
}
