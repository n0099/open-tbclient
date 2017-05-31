package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    private final /* synthetic */ long aWf;
    private final /* synthetic */ String aWi;
    final /* synthetic */ ap cPB;
    private final /* synthetic */ String cPo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar, long j, String str, String str2) {
        this.cPB = apVar;
        this.aWf = j;
        this.cPo = str;
        this.aWi = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.g gVar;
        MessageManager messageManager = MessageManager.getInstance();
        gVar = this.cPB.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(gVar.getPageActivity(), String.valueOf(this.aWf), this.cPo, this.aWi, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
