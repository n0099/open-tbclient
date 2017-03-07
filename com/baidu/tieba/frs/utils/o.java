package com.baidu.tieba.frs.utils;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    private final /* synthetic */ FrsActivity cbE;
    private final /* synthetic */ com.baidu.tieba.frs.view.o cbF;
    private final /* synthetic */ ShareFromFrsMsgData cbI;
    private final /* synthetic */ int cbJ;
    private final /* synthetic */ String cbK;
    private final /* synthetic */ long cbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cbE = frsActivity;
        this.cbF = oVar;
        this.cbJ = i;
        this.cbK = str;
        this.cbL = j;
        this.cbI = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cbE.HidenSoftKeyPad((InputMethodManager) this.cbE.getSystemService("input_method"), this.cbF.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cbE.getPageContext().getPageActivity(), this.cbJ, this.cbK, this.cbL, "from_share", this.cbF.getLeaveMsg(), this.cbI.toChatMessageContent())));
        aVar.dismiss();
    }
}
