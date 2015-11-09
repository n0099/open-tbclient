package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    private final /* synthetic */ String aFC;
    private final /* synthetic */ long aFz;
    private final /* synthetic */ String bsl;
    final /* synthetic */ aq bsx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, long j, String str, String str2) {
        this.bsx = aqVar;
        this.aFz = j;
        this.bsl = str;
        this.aFC = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.h hVar;
        MessageManager messageManager = MessageManager.getInstance();
        hVar = this.bsx.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(hVar.getPageActivity(), String.valueOf(this.aFz), this.bsl, this.aFC, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
