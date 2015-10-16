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
public class al implements a.b {
    final /* synthetic */ FrsActivity aUK;
    private final /* synthetic */ com.baidu.tieba.frs.view.p aUT;
    private final /* synthetic */ ShareFromFrsMsgData aUW;
    private final /* synthetic */ int aUX;
    private final /* synthetic */ String aUY;
    private final /* synthetic */ long aUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.aUK = frsActivity;
        this.aUT = pVar;
        this.aUX = i;
        this.aUY = str;
        this.aUZ = j;
        this.aUW = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUK.HidenSoftKeyPad((InputMethodManager) this.aUK.getSystemService("input_method"), this.aUT.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.aUK.getPageContext().getPageActivity(), this.aUX, this.aUY, this.aUZ, "from_share", this.aUT.getLeaveMsg(), this.aUW.toChatMessageContent())));
        aVar.dismiss();
    }
}
