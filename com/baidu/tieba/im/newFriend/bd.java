package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ bb bht;
    private final /* synthetic */ String bhv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, String str) {
        this.bht = bbVar;
        this.bhv = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r3) {
        ba baVar;
        be beVar;
        baVar = this.bht.bhs;
        beVar = baVar.bhr;
        beVar.fa(this.bhv);
    }
}
