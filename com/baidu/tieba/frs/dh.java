package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnClickListener {
    final /* synthetic */ df bkM;
    private final /* synthetic */ ThemeCardInUserData bkN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(df dfVar, ThemeCardInUserData themeCardInUserData) {
        this.bkM = dfVar;
        this.bkN = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.bkM.bek;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(baseActivity.getPageContext().getPageActivity(), this.bkN.getCardId())));
    }
}
