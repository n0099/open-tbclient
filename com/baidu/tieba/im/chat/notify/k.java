package com.baidu.tieba.im.chat.notify;

import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ g aSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.aSu = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.aSu.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
