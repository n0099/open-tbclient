package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aQh = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.data.j jVar;
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.data.j jVar2;
        com.baidu.tieba.data.j jVar3;
        jVar = this.aQh.aPQ;
        if (jVar != null) {
            jVar2 = this.aQh.aPQ;
            if (jVar2.CN() != null) {
                jVar3 = this.aQh.aPQ;
                if (jVar3.CN().size() > 0) {
                    z = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    baseFragmentActivity = this.aQh.mActivity;
                    messageManager.sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(baseFragmentActivity.getPageContext().getPageActivity(), false, z)));
                }
            }
        }
        z = false;
        MessageManager messageManager2 = MessageManager.getInstance();
        baseFragmentActivity = this.aQh.mActivity;
        messageManager2.sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(baseFragmentActivity.getPageContext().getPageActivity(), false, z)));
    }
}
