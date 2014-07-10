package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ com.baidu.tbadk.core.data.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(az azVar, com.baidu.tbadk.core.data.m mVar) {
        this.a = azVar;
        this.b = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        g gVar;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.b;
        String userId = this.b.y().getUserId();
        String name_show = this.b.y().getName_show();
        gVar = this.a.d;
        messageManager.sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bb(context, userId, name_show, gVar.g().getName())));
    }
}
