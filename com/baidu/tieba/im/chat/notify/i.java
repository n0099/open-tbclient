package com.baidu.tieba.im.chat.notify;

import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (!z) {
            this.a.a(new RequestMemoryListMessage(1));
        }
    }
}
