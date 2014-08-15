package com.baidu.tieba.frs.view;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Activity activity;
        int i;
        MessageManager messageManager = MessageManager.getInstance();
        activity = this.a.E;
        i = this.a.ak;
        messageManager.sendMessage(new CustomMessage(2002001, new at(activity, i, "exp_acce")));
        aVar.c();
    }
}
