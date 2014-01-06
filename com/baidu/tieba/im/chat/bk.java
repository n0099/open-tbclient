package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ba baVar) {
        this.a = baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bs bsVar;
        bs bsVar2;
        if (bool != null) {
            if (bool.booleanValue()) {
                bsVar2 = this.a.g;
                bsVar2.H();
                return;
            }
            bsVar = this.a.g;
            bsVar.I();
        }
    }
}
