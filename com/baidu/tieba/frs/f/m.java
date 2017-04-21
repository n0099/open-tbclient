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
    private final /* synthetic */ ShareFromFrsMsgData ccA;
    private final /* synthetic */ FrsActivity ccw;
    private final /* synthetic */ com.baidu.tieba.frs.view.o ccx;
    private final /* synthetic */ long ccy;
    private final /* synthetic */ String ccz;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ccw = frsActivity;
        this.ccx = oVar;
        this.ccy = j;
        this.val$name = str;
        this.ccz = str2;
        this.ccA = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ccw.HidenSoftKeyPad((InputMethodManager) this.ccw.getSystemService("input_method"), this.ccx.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ccw.getPageContext().getPageActivity(), this.ccy, this.val$name, this.ccz, 0, this.ccx.getLeaveMsg(), this.ccA.toChatMessageContent())));
        aVar.dismiss();
    }
}
