package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements com.baidu.tieba.view.d {
    final /* synthetic */ bc a;
    private final /* synthetic */ com.baidu.tbadk.core.data.i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bc bcVar, com.baidu.tbadk.core.data.i iVar) {
        this.a = bcVar;
        this.b = iVar;
    }

    @Override // com.baidu.tieba.view.d
    public void a(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (this.b != null && this.b.a() != null && i >= 0 && i < this.b.a().size()) {
            frsActivity = this.a.b;
            com.baidu.tbadk.core.f.a(frsActivity, "forum_live_ck");
            MessageManager messageManager = MessageManager.getInstance();
            frsActivity2 = this.a.b;
            messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.al(frsActivity2, this.b.a().get(i).getGroupId())));
        }
    }
}
