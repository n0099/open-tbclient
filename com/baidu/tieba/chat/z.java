package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f956a;
    private com.baidu.tieba.a.c b = null;

    public z(w wVar) {
        this.f956a = wVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        y yVar;
        y yVar2;
        super.b();
        yVar = this.f956a.k;
        if (yVar != null) {
            yVar2 = this.f956a.k;
            yVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        this.b = new com.baidu.tieba.a.c();
        com.baidu.tieba.a.c cVar = this.b;
        str = this.f956a.b;
        str2 = this.f956a.d;
        cVar.a(str, str2);
        if (this.b != null && this.b.b() && this.b.d() == 0) {
            this.f956a.h();
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f956a.j = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        y yVar;
        y yVar2;
        com.baidu.tieba.data.a.c cVar;
        y yVar3;
        com.baidu.tieba.data.a.c cVar2;
        super.a((Object) bool);
        if (bool.booleanValue()) {
            cVar = this.f956a.h;
            cVar.e();
            yVar3 = this.f956a.k;
            cVar2 = this.f956a.h;
            yVar3.a(true, null, false, 0, cVar2, false);
        } else if (this.b != null) {
            if (this.b.b()) {
                yVar2 = this.f956a.k;
                yVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                yVar = this.f956a.k;
                yVar.a(false, this.b.c(), false, 0, null, false);
            }
        }
        this.f956a.j = null;
    }
}
