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
public class ao implements a.b {
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ com.baidu.tieba.frs.view.v bhw;
    private final /* synthetic */ long bhx;
    private final /* synthetic */ String bhy;
    private final /* synthetic */ ShareFromFrsMsgData bhz;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsActivity frsActivity, com.baidu.tieba.frs.view.v vVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bhl = frsActivity;
        this.bhw = vVar;
        this.bhx = j;
        this.val$name = str;
        this.bhy = str2;
        this.bhz = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bhl.HidenSoftKeyPad((InputMethodManager) this.bhl.getSystemService("input_method"), this.bhw.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bhl.getPageContext().getPageActivity(), this.bhx, this.val$name, this.bhy, 0, this.bhw.getLeaveMsg(), this.bhz.toChatMessageContent())));
        aVar.dismiss();
    }
}
