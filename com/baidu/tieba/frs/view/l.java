package com.baidu.tieba.frs.view;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsHeaderView aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsHeaderView frsHeaderView) {
        this.aHJ = frsHeaderView;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        int i;
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aHJ.mContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        i = this.aHJ.aHy;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(pageActivity, i, "exp_acce")));
        aVar.dismiss();
    }
}
