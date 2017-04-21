package com.baidu.tieba.frs.f;

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
    private final /* synthetic */ ShareFromFrsMsgData ccA;
    private final /* synthetic */ int ccB;
    private final /* synthetic */ String ccC;
    private final /* synthetic */ long ccD;
    private final /* synthetic */ FrsActivity ccw;
    private final /* synthetic */ com.baidu.tieba.frs.view.o ccx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ccw = frsActivity;
        this.ccx = oVar;
        this.ccB = i;
        this.ccC = str;
        this.ccD = j;
        this.ccA = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ccw.HidenSoftKeyPad((InputMethodManager) this.ccw.getSystemService("input_method"), this.ccx.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ccw.getPageContext().getPageActivity(), this.ccB, this.ccC, this.ccD, "from_share", this.ccx.getLeaveMsg(), this.ccA.toChatMessageContent())));
        aVar.dismiss();
    }
}
