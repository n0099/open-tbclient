package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    private final /* synthetic */ ThemeCardInUserData bSj;
    final /* synthetic */ aa bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(aa aaVar, ThemeCardInUserData themeCardInUserData) {
        this.bTy = aaVar;
        this.bSj = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        tbPageContext = this.bTy.ajT;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(tbPageContext.getPageActivity(), this.bSj.getCardId())));
    }
}
