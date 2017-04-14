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
    final /* synthetic */ c cdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.cdO = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.cdO.aaX == null || this.cdO.aaX.getOrignalPage() == null || this.cdO.aaX.getOrignalPage().checkUpIsLogin()) && this.cdO.mForumId != null && this.cdO.mForumName != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.cdO.aaX.getPageActivity(), this.cdO.mForumId, this.cdO.mForumName, 0, 1)));
        }
    }
}
