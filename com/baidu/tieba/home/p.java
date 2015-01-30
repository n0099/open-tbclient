package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o aQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aQi = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.data.j jVar;
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.data.j jVar2;
        com.baidu.tieba.data.j jVar3;
        jVar = this.aQi.aPR;
        if (jVar != null) {
            jVar2 = this.aQi.aPR;
            if (jVar2.CT() != null) {
                jVar3 = this.aQi.aPR;
                if (jVar3.CT().size() > 0) {
                    z = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    baseFragmentActivity = this.aQi.mActivity;
                    messageManager.sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(baseFragmentActivity.getPageContext().getPageActivity(), false, z)));
                }
            }
        }
        z = false;
        MessageManager messageManager2 = MessageManager.getInstance();
        baseFragmentActivity = this.aQi.mActivity;
        messageManager2.sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(baseFragmentActivity.getPageContext().getPageActivity(), false, z)));
    }
}
