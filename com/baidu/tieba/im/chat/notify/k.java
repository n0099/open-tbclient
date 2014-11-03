package com.baidu.tieba.im.chat.notify;

import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ g aQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.aQQ = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (!z) {
            this.aQQ.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
