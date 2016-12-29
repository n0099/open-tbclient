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
    private final /* synthetic */ int bDs;
    private final /* synthetic */ String bDt;
    private final /* synthetic */ long bDu;
    private final /* synthetic */ FrsActivity bOc;
    private final /* synthetic */ com.baidu.tieba.frs.view.o bOd;
    private final /* synthetic */ ShareFromFrsMsgData bOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bOc = frsActivity;
        this.bOd = oVar;
        this.bDs = i;
        this.bDt = str;
        this.bDu = j;
        this.bOe = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bOc.HidenSoftKeyPad((InputMethodManager) this.bOc.getSystemService("input_method"), this.bOd.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bOc.getPageContext().getPageActivity(), this.bDs, this.bDt, this.bDu, "from_share", this.bOd.getLeaveMsg(), this.bOe.toChatMessageContent())));
        aVar.dismiss();
    }
}
