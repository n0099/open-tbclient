package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bXS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bXS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.bXS.Fp == null || this.bXS.Fp.getOrignalPage() == null || this.bXS.Fp.getOrignalPage().checkUpIsLogin()) && this.bXS.mForumId != null && this.bXS.mForumName != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.bXS.Fp.getPageActivity(), this.bXS.mForumId, this.bXS.mForumName, 0, 1)));
        }
    }
}
