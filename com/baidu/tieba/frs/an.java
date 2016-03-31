package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ com.baidu.tieba.frs.view.t bls;
    private final /* synthetic */ long blt;
    private final /* synthetic */ String blu;
    private final /* synthetic */ ShareFromFrsMsgData blv;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity, com.baidu.tieba.frs.view.t tVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.blk = frsActivity;
        this.bls = tVar;
        this.blt = j;
        this.val$name = str;
        this.blu = str2;
        this.blv = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.blk.HidenSoftKeyPad((InputMethodManager) this.blk.getSystemService("input_method"), this.bls.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.blk.getPageContext().getPageActivity(), this.blt, this.val$name, this.blu, 0, this.bls.getLeaveMsg(), this.blv.toChatMessageContent())));
        aVar.dismiss();
    }
}
