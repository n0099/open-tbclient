package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    private final /* synthetic */ String aXg;
    final /* synthetic */ bg aXs;
    private final /* synthetic */ long ayb;
    private final /* synthetic */ String aye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar, long j, String str, String str2) {
        this.aXs = bgVar;
        this.ayb = j;
        this.aXg = str;
        this.aye = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.j jVar;
        MessageManager messageManager = MessageManager.getInstance();
        jVar = this.aXs.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(jVar.getPageActivity(), String.valueOf(this.ayb), this.aXg, this.aye, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
