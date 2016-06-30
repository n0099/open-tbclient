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
    private final /* synthetic */ String bGA;
    private final /* synthetic */ long bGB;
    private final /* synthetic */ FrsActivity bGu;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bGv;
    private final /* synthetic */ ShareFromFrsMsgData bGy;
    private final /* synthetic */ int bGz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bGu = frsActivity;
        this.bGv = nVar;
        this.bGz = i;
        this.bGA = str;
        this.bGB = j;
        this.bGy = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bGu.HidenSoftKeyPad((InputMethodManager) this.bGu.getSystemService("input_method"), this.bGv.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bGu.getPageContext().getPageActivity(), this.bGz, this.bGA, this.bGB, "from_share", this.bGv.getLeaveMsg(), this.bGy.toChatMessageContent())));
        aVar.dismiss();
    }
}
