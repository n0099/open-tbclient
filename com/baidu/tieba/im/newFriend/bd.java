package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ bb bhf;
    private final /* synthetic */ String bhh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, String str) {
        this.bhf = bbVar;
        this.bhh = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r3) {
        ba baVar;
        be beVar;
        baVar = this.bhf.bhe;
        beVar = baVar.bhd;
        beVar.fa(this.bhh);
    }
}
