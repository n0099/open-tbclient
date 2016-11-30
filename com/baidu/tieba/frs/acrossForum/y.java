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
class y implements a.b {
    private final /* synthetic */ BaseActivity bXg;
    private final /* synthetic */ ac bXh;
    private final /* synthetic */ int bXi;
    private final /* synthetic */ String bXj;
    private final /* synthetic */ long bXk;
    private final /* synthetic */ ShareFromPBMsgData bXl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(BaseActivity baseActivity, ac acVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.bXg = baseActivity;
        this.bXh = acVar;
        this.bXi = i;
        this.bXj = str;
        this.bXk = j;
        this.bXl = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bXg.HidenSoftKeyPad((InputMethodManager) this.bXg.getSystemService("input_method"), this.bXh.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.bXg.getPageContext().getPageActivity(), this.bXi, this.bXj, this.bXk, "from_share", this.bXh.getLeaveMsg(), this.bXl.toChatMessageContent())));
        a.adR().jY("vip3");
        aVar.dismiss();
    }
}
