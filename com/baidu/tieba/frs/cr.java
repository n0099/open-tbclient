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
    private final /* synthetic */ FrsActivity bSP;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bSQ;
    private final /* synthetic */ ShareFromFrsMsgData bST;
    private final /* synthetic */ int bSU;
    private final /* synthetic */ String bSV;
    private final /* synthetic */ long bSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bSP = frsActivity;
        this.bSQ = nVar;
        this.bSU = i;
        this.bSV = str;
        this.bSW = j;
        this.bST = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(a aVar) {
        this.bSP.HidenSoftKeyPad((InputMethodManager) this.bSP.getSystemService("input_method"), this.bSQ.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bSP.getPageContext().getPageActivity(), this.bSU, this.bSV, this.bSW, "from_share", this.bSQ.getLeaveMsg(), this.bST.toChatMessageContent())));
        aVar.dismiss();
    }
}
