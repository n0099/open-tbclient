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
public class ap implements a.b {
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ com.baidu.tieba.frs.view.t bls;
    private final /* synthetic */ ShareFromFrsMsgData blv;
    private final /* synthetic */ int blw;
    private final /* synthetic */ String blx;
    private final /* synthetic */ long bly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsActivity frsActivity, com.baidu.tieba.frs.view.t tVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.blk = frsActivity;
        this.bls = tVar;
        this.blw = i;
        this.blx = str;
        this.bly = j;
        this.blv = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.blk.HidenSoftKeyPad((InputMethodManager) this.blk.getSystemService("input_method"), this.bls.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.blk.getPageContext().getPageActivity(), this.blw, this.blx, this.bly, "from_share", this.bls.getLeaveMsg(), this.blv.toChatMessageContent())));
        aVar.dismiss();
    }
}
