package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tieba.addresslist.im.newFriend.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ az aJi;
    private final /* synthetic */ String aJk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar, String str) {
        this.aJi = azVar;
        this.aJk = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r3) {
        ay ayVar;
        ay.a aVar;
        ayVar = this.aJi.aJh;
        aVar = ayVar.aJd;
        aVar.gt(this.aJk);
    }
}
