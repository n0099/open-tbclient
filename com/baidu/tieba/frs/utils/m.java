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
    private final /* synthetic */ FrsActivity bUs;
    private final /* synthetic */ com.baidu.tieba.frs.view.o bUt;
    private final /* synthetic */ long bUu;
    private final /* synthetic */ String bUv;
    private final /* synthetic */ ShareFromFrsMsgData bUw;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bUs = frsActivity;
        this.bUt = oVar;
        this.bUu = j;
        this.val$name = str;
        this.bUv = str2;
        this.bUw = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bUs.HidenSoftKeyPad((InputMethodManager) this.bUs.getSystemService("input_method"), this.bUt.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bUs.getPageContext().getPageActivity(), this.bUu, this.val$name, this.bUv, 0, this.bUt.getLeaveMsg(), this.bUw.toChatMessageContent())));
        aVar.dismiss();
    }
}
