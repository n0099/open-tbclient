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
    private final /* synthetic */ FrsActivity bGu;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bGv;
    private final /* synthetic */ long bGw;
    private final /* synthetic */ String bGx;
    private final /* synthetic */ ShareFromFrsMsgData bGy;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bGu = frsActivity;
        this.bGv = nVar;
        this.bGw = j;
        this.val$name = str;
        this.bGx = str2;
        this.bGy = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bGu.HidenSoftKeyPad((InputMethodManager) this.bGu.getSystemService("input_method"), this.bGv.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bGu.getPageContext().getPageActivity(), this.bGw, this.val$name, this.bGx, 0, this.bGv.getLeaveMsg(), this.bGy.toChatMessageContent())));
        aVar.dismiss();
    }
}
