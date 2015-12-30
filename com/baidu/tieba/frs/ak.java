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
public class ak implements a.b {
    final /* synthetic */ FrsActivity bed;
    private final /* synthetic */ com.baidu.tieba.frs.view.p bem;
    private final /* synthetic */ long ben;
    private final /* synthetic */ String beo;
    private final /* synthetic */ ShareFromFrsMsgData bep;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bed = frsActivity;
        this.bem = pVar;
        this.ben = j;
        this.val$name = str;
        this.beo = str2;
        this.bep = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bed.HidenSoftKeyPad((InputMethodManager) this.bed.getSystemService("input_method"), this.bem.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bed.getPageContext().getPageActivity(), this.ben, this.val$name, this.beo, 0, this.bem.getLeaveMsg(), this.bep.toChatMessageContent())));
        aVar.dismiss();
    }
}
