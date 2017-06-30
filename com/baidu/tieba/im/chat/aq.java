package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    private final /* synthetic */ String aXB;
    private final /* synthetic */ long aXy;
    private final /* synthetic */ String cXk;
    final /* synthetic */ ap cXx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar, long j, String str, String str2) {
        this.cXx = apVar;
        this.aXy = j;
        this.cXk = str;
        this.aXB = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.g gVar;
        MessageManager messageManager = MessageManager.getInstance();
        gVar = this.cXx.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(gVar.getPageActivity(), String.valueOf(this.aXy), this.cXk, this.aXB, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
