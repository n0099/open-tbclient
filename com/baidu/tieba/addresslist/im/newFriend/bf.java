package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ bd ayK;
    private final /* synthetic */ String ayM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bd bdVar, String str) {
        this.ayK = bdVar;
        this.ayM = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r3) {
        bc bcVar;
        bg bgVar;
        bcVar = this.ayK.ayJ;
        bgVar = bcVar.ayF;
        bgVar.fc(this.ayM);
    }
}
