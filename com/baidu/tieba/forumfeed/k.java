package com.baidu.tieba.forumfeed;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j ayv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.ayv = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.ayv.aye;
        messageManager.sendMessage(new CustomMessage(2010010, new SingleSquareActivityConfig(baseFragmentActivity)));
    }
}
