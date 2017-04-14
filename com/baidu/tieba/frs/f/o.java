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
    private final /* synthetic */ FrsActivity caf;
    private final /* synthetic */ com.baidu.tieba.frs.view.o cag;
    private final /* synthetic */ ShareFromFrsMsgData caj;
    private final /* synthetic */ int cak;
    private final /* synthetic */ String cal;
    private final /* synthetic */ long cam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.caf = frsActivity;
        this.cag = oVar;
        this.cak = i;
        this.cal = str;
        this.cam = j;
        this.caj = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.caf.HidenSoftKeyPad((InputMethodManager) this.caf.getSystemService("input_method"), this.cag.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.caf.getPageContext().getPageActivity(), this.cak, this.cal, this.cam, "from_share", this.cag.getLeaveMsg(), this.caj.toChatMessageContent())));
        aVar.dismiss();
    }
}
