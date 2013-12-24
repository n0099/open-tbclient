package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bc bcVar) {
        this.a = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bu buVar;
        bu buVar2;
        if (bool != null) {
            if (bool.booleanValue()) {
                buVar2 = this.a.g;
                buVar2.G();
                return;
            }
            buVar = this.a.g;
            buVar.H();
        }
    }
}
