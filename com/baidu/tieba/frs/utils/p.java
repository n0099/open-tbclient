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
public class p implements a.b {
    private final /* synthetic */ int bXi;
    private final /* synthetic */ String bXj;
    private final /* synthetic */ long bXk;
    private final /* synthetic */ FrsActivity ciV;
    private final /* synthetic */ com.baidu.tieba.frs.view.o ciW;
    private final /* synthetic */ ShareFromFrsMsgData ciX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ciV = frsActivity;
        this.ciW = oVar;
        this.bXi = i;
        this.bXj = str;
        this.bXk = j;
        this.ciX = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciV.HidenSoftKeyPad((InputMethodManager) this.ciV.getSystemService("input_method"), this.ciW.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ciV.getPageContext().getPageActivity(), this.bXi, this.bXj, this.bXk, "from_share", this.ciW.getLeaveMsg(), this.ciX.toChatMessageContent())));
        aVar.dismiss();
    }
}
