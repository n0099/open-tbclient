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
public class am implements a.b {
    final /* synthetic */ FrsActivity bed;
    private final /* synthetic */ com.baidu.tieba.frs.view.p bem;
    private final /* synthetic */ ShareFromFrsMsgData bep;
    private final /* synthetic */ int beq;
    private final /* synthetic */ String ber;
    private final /* synthetic */ long bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bed = frsActivity;
        this.bem = pVar;
        this.beq = i;
        this.ber = str;
        this.bes = j;
        this.bep = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bed.HidenSoftKeyPad((InputMethodManager) this.bed.getSystemService("input_method"), this.bem.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bed.getPageContext().getPageActivity(), this.beq, this.ber, this.bes, "from_share", this.bem.getLeaveMsg(), this.bep.toChatMessageContent())));
        aVar.dismiss();
    }
}
