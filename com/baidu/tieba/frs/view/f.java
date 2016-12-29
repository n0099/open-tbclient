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
    final /* synthetic */ c bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bRo = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.bRo.Gf == null || this.bRo.Gf.getOrignalPage() == null || this.bRo.Gf.getOrignalPage().checkUpIsLogin()) && this.bRo.mForumId != null && this.bRo.mForumName != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.bRo.Gf.getPageActivity(), this.bRo.mForumId, this.bRo.mForumName, 0, 1)));
        }
    }
}
