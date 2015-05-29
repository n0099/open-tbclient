package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    private final /* synthetic */ long azU;
    private final /* synthetic */ String azX;
    private final /* synthetic */ String bac;
    final /* synthetic */ bg bao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar, long j, String str, String str2) {
        this.bao = bgVar;
        this.azU = j;
        this.bac = str;
        this.azX = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.j jVar;
        MessageManager messageManager = MessageManager.getInstance();
        jVar = this.bao.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(jVar.getPageActivity(), String.valueOf(this.azU), this.bac, this.azX, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
