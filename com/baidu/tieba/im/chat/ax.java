package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    private final /* synthetic */ String aQN;
    final /* synthetic */ aw aQS;
    private final /* synthetic */ long aQT;
    private final /* synthetic */ String aQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, long j, String str, String str2) {
        this.aQS = awVar;
        this.aQT = j;
        this.aQN = str;
        this.aQU = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.j jVar;
        MessageManager messageManager = MessageManager.getInstance();
        jVar = this.aQS.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(jVar.getPageActivity(), String.valueOf(this.aQT), this.aQN, this.aQU, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
