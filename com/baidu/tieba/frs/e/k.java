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
    private final /* synthetic */ ShareFromFrsMsgData cgA;
    private final /* synthetic */ int cgB;
    private final /* synthetic */ String cgC;
    private final /* synthetic */ long cgD;
    private final /* synthetic */ com.baidu.tieba.frs.r cgw;
    private final /* synthetic */ com.baidu.tieba.frs.view.i cgx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar, int i, String str, long j, ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cgw = rVar;
        this.cgx = iVar;
        this.cgB = i;
        this.cgC = str;
        this.cgD = j;
        this.cgA = shareFromFrsMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cgw.HidenSoftKeyPad((InputMethodManager) this.cgw.getActivity().getSystemService("input_method"), this.cgx.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cgw.xw().getPageActivity(), this.cgB, this.cgC, this.cgD, "from_share", this.cgx.getLeaveMsg(), this.cgA.toChatMessageContent())));
        aVar.dismiss();
    }
}
