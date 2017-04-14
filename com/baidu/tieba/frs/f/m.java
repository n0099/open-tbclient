package com.baidu.tieba.frs.f;

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
    private final /* synthetic */ FrsActivity caf;
    private final /* synthetic */ com.baidu.tieba.frs.view.o cag;
    private final /* synthetic */ long cah;
    private final /* synthetic */ String cai;
    private final /* synthetic */ ShareFromFrsMsgData caj;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.caf = frsActivity;
        this.cag = oVar;
        this.cah = j;
        this.val$name = str;
        this.cai = str2;
        this.caj = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.caf.HidenSoftKeyPad((InputMethodManager) this.caf.getSystemService("input_method"), this.cag.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.caf.getPageContext().getPageActivity(), this.cah, this.val$name, this.cai, 0, this.cag.getLeaveMsg(), this.caj.toChatMessageContent())));
        aVar.dismiss();
    }
}
