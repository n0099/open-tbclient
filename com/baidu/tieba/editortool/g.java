package com.baidu.tieba.editortool;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.bubble.s {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.bubble.s
    public void a(int i) {
        com.baidu.tieba.model.e eVar;
        Context context;
        eVar = this.a.b;
        eVar.b(i);
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.d;
        messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.au(context, true, 23004, "pop_unable")));
    }

    @Override // com.baidu.tieba.bubble.s
    public void a() {
    }
}
