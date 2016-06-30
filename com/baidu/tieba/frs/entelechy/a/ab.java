package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    private final /* synthetic */ ThemeCardInUserData bIc;
    final /* synthetic */ y bJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar, ThemeCardInUserData themeCardInUserData) {
        this.bJN = yVar;
        this.bIc = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        tbPageContext = this.bJN.Ea;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(tbPageContext.getPageActivity(), this.bIc.getCardId())));
    }
}
