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
class aa implements a.b {
    private final /* synthetic */ BaseActivity bXg;
    private final /* synthetic */ ac bXh;
    private final /* synthetic */ long bXm;
    private final /* synthetic */ String bXn;
    private final /* synthetic */ ShareFromPBMsgData bXo;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(BaseActivity baseActivity, ac acVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bXg = baseActivity;
        this.bXh = acVar;
        this.bXm = j;
        this.val$name = str;
        this.bXn = str2;
        this.bXo = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bXg.HidenSoftKeyPad((InputMethodManager) this.bXg.getSystemService("input_method"), this.bXh.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bXg.getPageContext().getPageActivity(), this.bXm, this.val$name, this.bXn, 0, this.bXh.getLeaveMsg(), this.bXo.toChatMessageContent())));
        a.adR().jY("vip3");
        aVar.dismiss();
    }
}
