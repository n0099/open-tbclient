package com.baidu.tieba.frs.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsHeaderView aRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsHeaderView frsHeaderView) {
        this.aRv = frsHeaderView;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.aRv.LH.getPageActivity(), this.aRv.aRb, "exp_acce", 2)));
        aVar.dismiss();
    }
}
