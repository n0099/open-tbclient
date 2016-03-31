package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    private final /* synthetic */ long aNX;
    private final /* synthetic */ String aOa;
    private final /* synthetic */ String bZe;
    final /* synthetic */ aq bZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, long j, String str, String str2) {
        this.bZq = aqVar;
        this.aNX = j;
        this.bZe = str;
        this.aOa = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.h hVar;
        MessageManager messageManager = MessageManager.getInstance();
        hVar = this.bZq.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(hVar.getPageActivity(), String.valueOf(this.aNX), this.bZe, this.aOa, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
