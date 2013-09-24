package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f980a;
    private com.baidu.tieba.a.e b = null;

    public y(v vVar) {
        this.f980a = vVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        x xVar;
        x xVar2;
        super.b();
        xVar = this.f980a.k;
        if (xVar != null) {
            xVar2 = this.f980a.k;
            xVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        String str;
        String str2;
        this.b = new com.baidu.tieba.a.e();
        com.baidu.tieba.a.e eVar = this.b;
        str = this.f980a.b;
        str2 = this.f980a.d;
        eVar.a(str, str2);
        if (this.b != null && this.b.b() && this.b.d() == 0) {
            this.f980a.h();
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
        this.f980a.j = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        x xVar;
        x xVar2;
        com.baidu.tieba.data.a.c cVar;
        x xVar3;
        com.baidu.tieba.data.a.c cVar2;
        super.a((y) bool);
        if (bool.booleanValue()) {
            cVar = this.f980a.h;
            cVar.e();
            xVar3 = this.f980a.k;
            cVar2 = this.f980a.h;
            xVar3.a(true, null, false, 0, cVar2, false);
        } else if (this.b != null) {
            if (this.b.b()) {
                xVar2 = this.f980a.k;
                xVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                xVar = this.f980a.k;
                xVar.a(false, this.b.c(), false, 0, null, false);
            }
        }
        this.f980a.j = null;
    }
}
