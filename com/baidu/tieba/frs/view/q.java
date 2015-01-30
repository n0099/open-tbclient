package com.baidu.tieba.frs.view;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ o aJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.aJb = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        int i;
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aJb.mContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        i = this.aJb.aII;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(pageActivity, i, "exp_acce")));
        aVar.dismiss();
    }
}
