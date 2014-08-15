package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ ax a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar, String str) {
        this.a = axVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        aw awVar;
        ba baVar;
        awVar = this.a.a;
        baVar = awVar.a;
        baVar.a(this.b);
    }
}
