package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tieba.im.model.ai {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // com.baidu.tieba.im.model.ai
    public void a(int i, com.baidu.tieba.im.message.b bVar) {
        this.a.e.post(new be(this, i, bVar));
    }
}
