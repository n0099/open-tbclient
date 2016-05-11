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
public class aq implements a.b {
    private final /* synthetic */ int bhA;
    private final /* synthetic */ String bhB;
    private final /* synthetic */ long bhC;
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ com.baidu.tieba.frs.view.v bhw;
    private final /* synthetic */ ShareFromFrsMsgData bhz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity, com.baidu.tieba.frs.view.v vVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bhl = frsActivity;
        this.bhw = vVar;
        this.bhA = i;
        this.bhB = str;
        this.bhC = j;
        this.bhz = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bhl.HidenSoftKeyPad((InputMethodManager) this.bhl.getSystemService("input_method"), this.bhw.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bhl.getPageContext().getPageActivity(), this.bhA, this.bhB, this.bhC, "from_share", this.bhw.getLeaveMsg(), this.bhz.toChatMessageContent())));
        aVar.dismiss();
    }
}
