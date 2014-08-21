package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.d;
        messageManager.sendMessage(new CustomMessage(2002001, new bl(context, "motu")));
        aVar.d();
    }
}
