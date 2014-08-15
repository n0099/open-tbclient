package com.baidu.tieba.frs.view;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Activity activity;
        int i;
        MessageManager messageManager = MessageManager.getInstance();
        activity = this.a.B;
        i = this.a.ap;
        messageManager.sendMessage(new CustomMessage(2002001, new at(activity, i, "exp_acce")));
        aVar.c();
    }
}
