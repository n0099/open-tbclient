package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ com.baidu.tbadk.core.data.n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(az azVar, com.baidu.tbadk.core.data.n nVar) {
        this.a = azVar;
        this.b = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.b;
        messageManager.sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.at(context, this.b.y().getUserId(), this.b.y().getName_show())));
    }
}
