package com.baidu.tieba.im.chat.notify;

import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ g aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.aTD = gVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.aTD.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
