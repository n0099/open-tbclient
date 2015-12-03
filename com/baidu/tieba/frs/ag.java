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
public class ag implements a.b {
    final /* synthetic */ FrsActivity bag;
    private final /* synthetic */ com.baidu.tieba.frs.view.p ban;
    private final /* synthetic */ long bao;
    private final /* synthetic */ String bap;
    private final /* synthetic */ ShareFromFrsMsgData baq;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bag = frsActivity;
        this.ban = pVar;
        this.bao = j;
        this.val$name = str;
        this.bap = str2;
        this.baq = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bag.HidenSoftKeyPad((InputMethodManager) this.bag.getSystemService("input_method"), this.ban.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bag.getPageContext().getPageActivity(), this.bao, this.val$name, this.bap, 0, this.ban.getLeaveMsg(), this.baq.toChatMessageContent())));
        aVar.dismiss();
    }
}
