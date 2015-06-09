package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ bd aAE;
    private final /* synthetic */ String aAG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bd bdVar, String str) {
        this.aAE = bdVar;
        this.aAG = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r3) {
        bc bcVar;
        bg bgVar;
        bcVar = this.aAE.aAD;
        bgVar = bcVar.aAz;
        bgVar.fA(this.aAG);
    }
}
