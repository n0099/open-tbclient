package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    final /* synthetic */ FrsActivity aUS;
    private final /* synthetic */ com.baidu.tieba.frs.view.p aVb;
    private final /* synthetic */ ShareFromFrsMsgData aVe;
    private final /* synthetic */ int aVf;
    private final /* synthetic */ String aVg;
    private final /* synthetic */ long aVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.aUS = frsActivity;
        this.aVb = pVar;
        this.aVf = i;
        this.aVg = str;
        this.aVh = j;
        this.aVe = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUS.HidenSoftKeyPad((InputMethodManager) this.aUS.getSystemService("input_method"), this.aVb.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.aUS.getPageContext().getPageActivity(), this.aVf, this.aVg, this.aVh, "from_share", this.aVb.getLeaveMsg(), this.aVe.toChatMessageContent())));
        aVar.dismiss();
    }
}
