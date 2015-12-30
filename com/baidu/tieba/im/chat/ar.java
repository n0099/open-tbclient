package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    private final /* synthetic */ long aJW;
    private final /* synthetic */ String aJZ;
    private final /* synthetic */ String bKY;
    final /* synthetic */ aq bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, long j, String str, String str2) {
        this.bLk = aqVar;
        this.aJW = j;
        this.bKY = str;
        this.aJZ = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.h hVar;
        MessageManager messageManager = MessageManager.getInstance();
        hVar = this.bLk.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(hVar.getPageActivity(), String.valueOf(this.aJW), this.bKY, this.aJZ, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
