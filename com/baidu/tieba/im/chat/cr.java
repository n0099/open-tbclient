package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements com.baidu.tieba.im.model.ak {
    final /* synthetic */ cp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cp cpVar) {
        this.a = cpVar;
    }

    @Override // com.baidu.tieba.im.model.ak
    public void a(int i, com.baidu.tieba.im.message.b bVar) {
        this.a.c.post(new cs(this, i, bVar));
    }
}
