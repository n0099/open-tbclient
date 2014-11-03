package com.baidu.tieba.editortool;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.bubble.s {
    final /* synthetic */ a aql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aql = aVar;
    }

    @Override // com.baidu.tieba.bubble.s
    public void dV(int i) {
        com.baidu.tieba.model.e eVar;
        Context context;
        eVar = this.aql.aqf;
        eVar.gz(i);
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aql.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(context, true, 23004, "pop_unable")));
    }

    @Override // com.baidu.tieba.bubble.s
    public void yk() {
    }
}
