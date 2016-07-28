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
public class cv implements a.b {
    private final /* synthetic */ FrsActivity bHQ;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bHR;
    private final /* synthetic */ ShareFromFrsMsgData bHU;
    private final /* synthetic */ int bHV;
    private final /* synthetic */ String bHW;
    private final /* synthetic */ long bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bHQ = frsActivity;
        this.bHR = nVar;
        this.bHV = i;
        this.bHW = str;
        this.bHX = j;
        this.bHU = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bHQ.HidenSoftKeyPad((InputMethodManager) this.bHQ.getSystemService("input_method"), this.bHR.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bHQ.getPageContext().getPageActivity(), this.bHV, this.bHW, this.bHX, "from_share", this.bHR.getLeaveMsg(), this.bHU.toChatMessageContent())));
        aVar.dismiss();
    }
}
