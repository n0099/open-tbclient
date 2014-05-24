package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tieba.view.e {
    final /* synthetic */ az a;
    private final /* synthetic */ com.baidu.tbadk.core.data.h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(az azVar, com.baidu.tbadk.core.data.h hVar) {
        this.a = azVar;
        this.b = hVar;
    }

    @Override // com.baidu.tieba.view.e
    public void a(int i) {
        Context context;
        if (this.b != null && this.b.a() != null && i >= 0 && i < this.b.a().size()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.a.b;
            messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ae(context, this.b.a().get(i).getGroupId())));
        }
    }
}
