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
    private final /* synthetic */ FrsActivity cbE;
    private final /* synthetic */ com.baidu.tieba.frs.view.o cbF;
    private final /* synthetic */ long cbG;
    private final /* synthetic */ String cbH;
    private final /* synthetic */ ShareFromFrsMsgData cbI;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cbE = frsActivity;
        this.cbF = oVar;
        this.cbG = j;
        this.val$name = str;
        this.cbH = str2;
        this.cbI = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cbE.HidenSoftKeyPad((InputMethodManager) this.cbE.getSystemService("input_method"), this.cbF.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cbE.getPageContext().getPageActivity(), this.cbG, this.val$name, this.cbH, 0, this.cbF.getLeaveMsg(), this.cbI.toChatMessageContent())));
        aVar.dismiss();
    }
}
