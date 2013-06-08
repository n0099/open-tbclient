package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.a.a {
    final /* synthetic */ w a;
    private com.baidu.tieba.b.c b = null;

    public z(w wVar) {
        this.a = wVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        y yVar;
        y yVar2;
        super.b();
        yVar = this.a.o;
        if (yVar != null) {
            yVar2 = this.a.o;
            yVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        this.b = new com.baidu.tieba.b.c();
        com.baidu.tieba.b.c cVar = this.b;
        str = this.a.f;
        str2 = this.a.h;
        cVar.a(str, str2);
        if (this.b != null && this.b.b() && this.b.d() == 0) {
            this.a.k();
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.a.n = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        y yVar;
        y yVar2;
        com.baidu.tieba.a.a.c cVar;
        y yVar3;
        com.baidu.tieba.a.a.c cVar2;
        super.a((Object) bool);
        if (bool.booleanValue()) {
            cVar = this.a.l;
            cVar.e();
            yVar3 = this.a.o;
            cVar2 = this.a.l;
            yVar3.a(true, null, false, 0, cVar2, false);
        } else if (this.b != null) {
            if (this.b.b()) {
                yVar2 = this.a.o;
                yVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                yVar = this.a.o;
                yVar.a(false, this.b.c(), false, 0, null, false);
            }
        }
        this.a.n = null;
    }
}
