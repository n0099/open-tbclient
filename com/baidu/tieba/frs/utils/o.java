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
    private final /* synthetic */ FrsActivity bUs;
    private final /* synthetic */ com.baidu.tieba.frs.view.o bUt;
    private final /* synthetic */ ShareFromFrsMsgData bUw;
    private final /* synthetic */ int bUx;
    private final /* synthetic */ String bUy;
    private final /* synthetic */ long bUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bUs = frsActivity;
        this.bUt = oVar;
        this.bUx = i;
        this.bUy = str;
        this.bUz = j;
        this.bUw = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bUs.HidenSoftKeyPad((InputMethodManager) this.bUs.getSystemService("input_method"), this.bUt.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bUs.getPageContext().getPageActivity(), this.bUx, this.bUy, this.bUz, "from_share", this.bUt.getLeaveMsg(), this.bUw.toChatMessageContent())));
        aVar.dismiss();
    }
}
