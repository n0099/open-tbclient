package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tieba.im.model.ai {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.a = baVar;
    }

    @Override // com.baidu.tieba.im.model.ai
    public void a(int i, com.baidu.tieba.im.message.b bVar) {
        this.a.e.post(new bc(this, i, bVar));
    }
}
