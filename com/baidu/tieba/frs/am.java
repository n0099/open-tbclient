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
public class am implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.view.s bgH;
    private final /* synthetic */ long bgI;
    private final /* synthetic */ String bgJ;
    private final /* synthetic */ ShareFromFrsMsgData bgK;
    final /* synthetic */ FrsActivity bgz;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tieba.frs.view.s sVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bgz = frsActivity;
        this.bgH = sVar;
        this.bgI = j;
        this.val$name = str;
        this.bgJ = str2;
        this.bgK = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.bgz.HidenSoftKeyPad((InputMethodManager) this.bgz.getSystemService("input_method"), this.bgH.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bgz.getPageContext().getPageActivity(), this.bgI, this.val$name, this.bgJ, 0, this.bgH.getLeaveMsg(), this.bgK.toChatMessageContent())));
        aVar.dismiss();
    }
}
