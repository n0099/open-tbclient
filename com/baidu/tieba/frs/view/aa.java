package com.baidu.tieba.frs.view;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ r aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.aGu = rVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Activity activity;
        int i;
        MessageManager messageManager = MessageManager.getInstance();
        activity = this.aGu.aBP;
        i = this.aGu.aFT;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(activity, i, "exp_acce")));
        aVar.dismiss();
    }
}
