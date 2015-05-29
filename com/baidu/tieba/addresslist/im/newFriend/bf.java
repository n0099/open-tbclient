package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ bd aAD;
    private final /* synthetic */ String aAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bd bdVar, String str) {
        this.aAD = bdVar;
        this.aAF = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r3) {
        bc bcVar;
        bg bgVar;
        bcVar = this.aAD.aAC;
        bgVar = bcVar.aAy;
        bgVar.fA(this.aAF);
    }
}
