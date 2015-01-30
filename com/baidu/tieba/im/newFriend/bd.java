package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ bb blL;
    private final /* synthetic */ String blN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, String str) {
        this.blL = bbVar;
        this.blN = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r3) {
        ba baVar;
        be beVar;
        baVar = this.blL.blK;
        beVar = baVar.blG;
        beVar.fA(this.blN);
    }
}
