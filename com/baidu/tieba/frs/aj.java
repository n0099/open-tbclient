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
public class aj implements a.b {
    final /* synthetic */ FrsActivity aUK;
    private final /* synthetic */ com.baidu.tieba.frs.view.p aUT;
    private final /* synthetic */ long aUU;
    private final /* synthetic */ String aUV;
    private final /* synthetic */ ShareFromFrsMsgData aUW;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.aUK = frsActivity;
        this.aUT = pVar;
        this.aUU = j;
        this.val$name = str;
        this.aUV = str2;
        this.aUW = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUK.HidenSoftKeyPad((InputMethodManager) this.aUK.getSystemService("input_method"), this.aUT.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aUK.getPageContext().getPageActivity(), this.aUU, this.val$name, this.aUV, 0, this.aUT.getLeaveMsg(), this.aUW.toChatMessageContent())));
        aVar.dismiss();
    }
}
