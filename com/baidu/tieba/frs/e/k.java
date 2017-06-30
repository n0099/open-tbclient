package com.baidu.tieba.frs.e;

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
    private final /* synthetic */ com.baidu.tieba.frs.r coM;
    private final /* synthetic */ com.baidu.tieba.frs.view.i coN;
    private final /* synthetic */ ShareFromFrsMsgData coQ;
    private final /* synthetic */ int coR;
    private final /* synthetic */ String coS;
    private final /* synthetic */ long coT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.coM = rVar;
        this.coN = iVar;
        this.coR = i;
        this.coS = str;
        this.coT = j;
        this.coQ = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.coM.HidenSoftKeyPad((InputMethodManager) this.coM.getActivity().getSystemService("input_method"), this.coN.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.coM.xN().getPageActivity(), this.coR, this.coS, this.coT, "from_share", this.coN.getLeaveMsg(), this.coQ.toChatMessageContent())));
        aVar.dismiss();
    }
}
