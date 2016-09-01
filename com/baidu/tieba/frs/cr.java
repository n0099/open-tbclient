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
public class cr implements a.b {
    private final /* synthetic */ FrsActivity bSW;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bSX;
    private final /* synthetic */ ShareFromFrsMsgData bTa;
    private final /* synthetic */ int bTb;
    private final /* synthetic */ String bTc;
    private final /* synthetic */ long bTd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bSW = frsActivity;
        this.bSX = nVar;
        this.bTb = i;
        this.bTc = str;
        this.bTd = j;
        this.bTa = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(a aVar) {
        this.bSW.HidenSoftKeyPad((InputMethodManager) this.bSW.getSystemService("input_method"), this.bSX.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bSW.getPageContext().getPageActivity(), this.bTb, this.bTc, this.bTd, "from_share", this.bSX.getLeaveMsg(), this.bTa.toChatMessageContent())));
        aVar.dismiss();
    }
}
