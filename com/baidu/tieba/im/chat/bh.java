package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ bg aXI;
    private final /* synthetic */ String aXw;
    private final /* synthetic */ long ayj;
    private final /* synthetic */ String aym;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar, long j, String str, String str2) {
        this.aXI = bgVar;
        this.ayj = j;
        this.aXw = str;
        this.aym = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.j jVar;
        MessageManager messageManager = MessageManager.getInstance();
        jVar = this.aXI.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(jVar.getPageActivity(), String.valueOf(this.ayj), this.aXw, this.aym, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
