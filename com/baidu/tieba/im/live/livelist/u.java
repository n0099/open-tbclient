package com.baidu.tieba.im.live.livelist;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsLiveListActivity frsLiveListActivity;
        MessageManager messageManager = MessageManager.getInstance();
        frsLiveListActivity = this.a.a;
        messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.aa(frsLiveListActivity)));
    }
}
