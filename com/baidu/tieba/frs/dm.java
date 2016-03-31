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
public class dm implements View.OnClickListener {
    final /* synthetic */ dk bpw;
    private final /* synthetic */ ThemeCardInUserData bpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dk dkVar, ThemeCardInUserData themeCardInUserData) {
        this.bpw = dkVar;
        this.bpx = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.bpw.bix;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(baseActivity.getPageContext().getPageActivity(), this.bpx.getCardId())));
    }
}
