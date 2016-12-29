package com.baidu.tieba.frs.acrossForum;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* loaded from: classes.dex */
class x implements a.b {
    private final /* synthetic */ BaseActivity bDq;
    private final /* synthetic */ ab bDr;
    private final /* synthetic */ int bDs;
    private final /* synthetic */ String bDt;
    private final /* synthetic */ long bDu;
    private final /* synthetic */ ShareFromPBMsgData bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(BaseActivity baseActivity, ab abVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.bDq = baseActivity;
        this.bDr = abVar;
        this.bDs = i;
        this.bDt = str;
        this.bDu = j;
        this.bDv = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bDq.HidenSoftKeyPad((InputMethodManager) this.bDq.getSystemService("input_method"), this.bDr.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bDq.getPageContext().getPageActivity(), this.bDs, this.bDt, this.bDu, "from_share", this.bDr.getLeaveMsg(), this.bDv.toChatMessageContent())));
        a.Yl().iD("vip3");
        aVar.dismiss();
    }
}
