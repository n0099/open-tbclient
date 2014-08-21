package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ bb a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, String str) {
        this.a = bbVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        ba baVar;
        be beVar;
        baVar = this.a.a;
        beVar = baVar.a;
        beVar.a(this.b);
    }
}
