package com.baidu.tieba.frs.acrossForum;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* loaded from: classes.dex */
class z implements a.b {
    private final /* synthetic */ BaseActivity bDq;
    private final /* synthetic */ ab bDr;
    private final /* synthetic */ long bDw;
    private final /* synthetic */ String bDx;
    private final /* synthetic */ ShareFromPBMsgData bDy;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(BaseActivity baseActivity, ab abVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bDq = baseActivity;
        this.bDr = abVar;
        this.bDw = j;
        this.val$name = str;
        this.bDx = str2;
        this.bDy = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bDq.HidenSoftKeyPad((InputMethodManager) this.bDq.getSystemService("input_method"), this.bDr.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bDq.getPageContext().getPageActivity(), this.bDw, this.val$name, this.bDx, 0, this.bDr.getLeaveMsg(), this.bDy.toChatMessageContent())));
        a.Yl().iD("vip3");
        aVar.dismiss();
    }
}
