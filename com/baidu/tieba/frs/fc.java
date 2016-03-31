package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class fc implements View.OnClickListener {
    private final /* synthetic */ ThemeCardInUserData bpx;
    final /* synthetic */ fa bqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(fa faVar, ThemeCardInUserData themeCardInUserData) {
        this.bqT = faVar;
        this.bpx = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(this.bqT.bix.getPageContext().getPageActivity(), this.bpx.getCardId())));
    }
}
