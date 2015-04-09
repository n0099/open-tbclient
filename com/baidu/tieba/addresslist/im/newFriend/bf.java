package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ bd ayS;
    private final /* synthetic */ String ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bd bdVar, String str) {
        this.ayS = bdVar;
        this.ayU = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r3) {
        bc bcVar;
        bg bgVar;
        bcVar = this.ayS.ayR;
        bgVar = bcVar.ayN;
        bgVar.ff(this.ayU);
    }
}
