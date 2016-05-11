package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class et implements View.OnClickListener {
    private final /* synthetic */ ThemeCardInUserData bkN;
    final /* synthetic */ er bmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public et(er erVar, ThemeCardInUserData themeCardInUserData) {
        this.bmg = erVar;
        this.bkN = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(this.bmg.bek.getPageContext().getPageActivity(), this.bkN.getCardId())));
    }
}
