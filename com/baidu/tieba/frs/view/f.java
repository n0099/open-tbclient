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
    final /* synthetic */ c cme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.cme = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.cme.Gf == null || this.cme.Gf.getOrignalPage() == null || this.cme.Gf.getOrignalPage().checkUpIsLogin()) && this.cme.mForumId != null && this.cme.mForumName != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.cme.Gf.getPageActivity(), this.cme.mForumId, this.cme.mForumName, 0, 1)));
        }
    }
}
