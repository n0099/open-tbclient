package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    private final /* synthetic */ String aRW;
    final /* synthetic */ az aSb;
    private final /* synthetic */ long aSc;
    private final /* synthetic */ String aSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, long j, String str, String str2) {
        this.aSb = azVar;
        this.aSc = j;
        this.aRW = str;
        this.aSd = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.j jVar;
        MessageManager messageManager = MessageManager.getInstance();
        jVar = this.aSb.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(jVar.getPageActivity(), String.valueOf(this.aSc), this.aRW, this.aSd, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
