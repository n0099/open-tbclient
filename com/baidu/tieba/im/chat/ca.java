package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    private final /* synthetic */ String aOO;
    final /* synthetic */ bz aOT;
    private final /* synthetic */ long aOU;
    private final /* synthetic */ String aOV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, long j, String str, String str2) {
        this.aOT = bzVar;
        this.aOU = j;
        this.aOO = str;
        this.aOV = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aOT.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context, String.valueOf(this.aOU), this.aOO, this.aOV, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
