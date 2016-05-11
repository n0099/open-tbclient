package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ef implements View.OnClickListener {
    private final /* synthetic */ ThemeCardInUserData bkN;
    final /* synthetic */ ee blP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar, ThemeCardInUserData themeCardInUserData) {
        this.blP = eeVar;
        this.bkN = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(this.blP.bek.getPageContext().getPageActivity(), this.bkN.getCardId())));
    }
}
