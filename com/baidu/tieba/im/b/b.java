package com.baidu.tieba.im.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ a b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.b = aVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().a(this.c, false);
        return null;
    }
}
