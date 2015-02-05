package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {
    private final /* synthetic */ String aRV;
    final /* synthetic */ az aSa;
    private final /* synthetic */ long aSb;
    private final /* synthetic */ String aSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, long j, String str, String str2) {
        this.aSa = azVar;
        this.aSb = j;
        this.aRV = str;
        this.aSc = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.j jVar;
        MessageManager messageManager = MessageManager.getInstance();
        jVar = this.aSa.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(jVar.getPageActivity(), String.valueOf(this.aSb), this.aRV, this.aSc, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
