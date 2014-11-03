package com.baidu.tieba.frs.view;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsHeaderView aGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsHeaderView frsHeaderView) {
        this.aGd = frsHeaderView;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Activity activity;
        int i;
        MessageManager messageManager = MessageManager.getInstance();
        activity = this.aGd.aBP;
        i = this.aGd.aFT;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(activity, i, "exp_acce")));
        aVar.dismiss();
    }
}
