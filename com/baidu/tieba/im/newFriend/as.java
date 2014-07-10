package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ aq a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar, String str) {
        this.a = aqVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        ap apVar;
        at atVar;
        apVar = this.a.a;
        atVar = apVar.a;
        atVar.a(this.b);
    }
}
