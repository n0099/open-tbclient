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
    final /* synthetic */ c cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.cgf = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.cgf.aaY == null || this.cgf.aaY.getOrignalPage() == null || this.cgf.aaY.getOrignalPage().checkUpIsLogin()) && this.cgf.mForumId != null && this.cgf.mForumName != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.cgf.aaY.getPageActivity(), this.cgf.mForumId, this.cgf.mForumName, 0, 1)));
        }
    }
}
