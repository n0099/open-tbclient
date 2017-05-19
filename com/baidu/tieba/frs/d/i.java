package com.baidu.tieba.frs.d;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
/* loaded from: classes.dex */
class i implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.r cak;
    private final /* synthetic */ com.baidu.tieba.frs.view.i cal;
    private final /* synthetic */ long cam;
    private final /* synthetic */ String can;
    private final /* synthetic */ ShareFromFrsMsgData cao;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cak = rVar;
        this.cal = iVar;
        this.cam = j;
        this.val$name = str;
        this.can = str2;
        this.cao = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cak.HidenSoftKeyPad((InputMethodManager) this.cak.getActivity().getSystemService("input_method"), this.cal.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cak.getPageContext().getPageActivity(), this.cam, this.val$name, this.can, 0, this.cal.getLeaveMsg(), this.cao.toChatMessageContent())));
        aVar.dismiss();
    }
}
