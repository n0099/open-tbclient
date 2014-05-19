package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ ba a;
    private final /* synthetic */ com.baidu.tbadk.core.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ba baVar, com.baidu.tbadk.core.data.o oVar) {
        this.a = baVar;
        this.b = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.a;
        messageManager.sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.at(context, this.b.t().getUserId(), this.b.t().getName_show())));
    }
}
