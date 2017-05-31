package com.baidu.tieba.frs.e;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
/* loaded from: classes.dex */
class i implements a.b {
    private final /* synthetic */ ShareFromFrsMsgData cgA;
    private final /* synthetic */ com.baidu.tieba.frs.r cgw;
    private final /* synthetic */ com.baidu.tieba.frs.view.i cgx;
    private final /* synthetic */ long cgy;
    private final /* synthetic */ String cgz;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cgw = rVar;
        this.cgx = iVar;
        this.cgy = j;
        this.val$name = str;
        this.cgz = str2;
        this.cgA = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cgw.HidenSoftKeyPad((InputMethodManager) this.cgw.getActivity().getSystemService("input_method"), this.cgx.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cgw.getPageContext().getPageActivity(), this.cgy, this.val$name, this.cgz, 0, this.cgx.getLeaveMsg(), this.cgA.toChatMessageContent())));
        aVar.dismiss();
    }
}
