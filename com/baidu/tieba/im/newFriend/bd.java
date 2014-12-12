package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ bb bko;
    private final /* synthetic */ String bkq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, String str) {
        this.bko = bbVar;
        this.bkq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r3) {
        ba baVar;
        be beVar;
        baVar = this.bko.bkn;
        beVar = baVar.bkj;
        beVar.fv(this.bkq);
    }
}
