package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bk;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.b;
        messageManager.sendMessage(new CustomMessage(2002001, new bk(context, "BdSocialShareSdk")));
    }
}
