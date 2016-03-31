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
public class dz implements View.OnClickListener {
    private final /* synthetic */ ThemeCardInUserData bpx;
    final /* synthetic */ dx bqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dx dxVar, ThemeCardInUserData themeCardInUserData) {
        this.bqd = dxVar;
        this.bpx = themeCardInUserData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.bqd.bix;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(baseActivity.getPageContext().getPageActivity(), this.bpx.getCardId())));
    }
}
