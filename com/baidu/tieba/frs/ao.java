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
public class ao implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.view.s bgH;
    private final /* synthetic */ ShareFromFrsMsgData bgK;
    private final /* synthetic */ int bgL;
    private final /* synthetic */ String bgM;
    private final /* synthetic */ long bgN;
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsActivity frsActivity, com.baidu.tieba.frs.view.s sVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bgz = frsActivity;
        this.bgH = sVar;
        this.bgL = i;
        this.bgM = str;
        this.bgN = j;
        this.bgK = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.bgz.HidenSoftKeyPad((InputMethodManager) this.bgz.getSystemService("input_method"), this.bgH.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bgz.getPageContext().getPageActivity(), this.bgL, this.bgM, this.bgN, "from_share", this.bgH.getLeaveMsg(), this.bgK.toChatMessageContent())));
        aVar.dismiss();
    }
}
