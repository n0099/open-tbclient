package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ bd a;
    private final /* synthetic */ com.baidu.tbadk.core.data.n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bd bdVar, com.baidu.tbadk.core.data.n nVar) {
        this.a = bdVar;
        this.b = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        g gVar;
        MessageManager messageManager = MessageManager.getInstance();
        frsActivity = this.a.b;
        String userId = this.b.q().getUserId();
        String name_show = this.b.q().getName_show();
        gVar = this.a.d;
        messageManager.sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bh(frsActivity, userId, name_show, gVar.i().getName(), "frs_head")));
    }
}
