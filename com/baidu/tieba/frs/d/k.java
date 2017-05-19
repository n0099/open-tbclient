package com.baidu.tieba.frs.d;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.r cak;
    private final /* synthetic */ com.baidu.tieba.frs.view.i cal;
    private final /* synthetic */ ShareFromFrsMsgData cao;
    private final /* synthetic */ int cap;
    private final /* synthetic */ String caq;
    private final /* synthetic */ long car;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cak = rVar;
        this.cal = iVar;
        this.cap = i;
        this.caq = str;
        this.car = j;
        this.cao = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cak.HidenSoftKeyPad((InputMethodManager) this.cak.getActivity().getSystemService("input_method"), this.cal.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cak.xD().getPageActivity(), this.cap, this.caq, this.car, "from_share", this.cal.getLeaveMsg(), this.cao.toChatMessageContent())));
        aVar.dismiss();
    }
}
