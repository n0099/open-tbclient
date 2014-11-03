package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    private final /* synthetic */ String aPc;
    final /* synthetic */ bz aPh;
    private final /* synthetic */ long aPi;
    private final /* synthetic */ String aPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, long j, String str, String str2) {
        this.aPh = bzVar;
        this.aPi = j;
        this.aPc = str;
        this.aPj = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aPh.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context, String.valueOf(this.aPi), this.aPc, this.aPj, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
