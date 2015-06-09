package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    private final /* synthetic */ long azV;
    private final /* synthetic */ String azY;
    private final /* synthetic */ String bad;
    final /* synthetic */ bg bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar, long j, String str, String str2) {
        this.bap = bgVar;
        this.azV = j;
        this.bad = str;
        this.azY = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.j jVar;
        MessageManager messageManager = MessageManager.getInstance();
        jVar = this.bap.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(jVar.getPageActivity(), String.valueOf(this.azV), this.bad, this.azY, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }
}
