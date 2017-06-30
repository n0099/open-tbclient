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
    private final /* synthetic */ com.baidu.tieba.frs.r coM;
    private final /* synthetic */ com.baidu.tieba.frs.view.i coN;
    private final /* synthetic */ long coO;
    private final /* synthetic */ String coP;
    private final /* synthetic */ ShareFromFrsMsgData coQ;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar, long j, String str, String str2, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.coM = rVar;
        this.coN = iVar;
        this.coO = j;
        this.val$name = str;
        this.coP = str2;
        this.coQ = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.coM.HidenSoftKeyPad((InputMethodManager) this.coM.getActivity().getSystemService("input_method"), this.coN.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.coM.getPageContext().getPageActivity(), this.coO, this.val$name, this.coP, 0, this.coN.getLeaveMsg(), this.coQ.toChatMessageContent())));
        aVar.dismiss();
    }
}
