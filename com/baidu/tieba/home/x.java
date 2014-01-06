package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Object, Integer, u> {
    final /* synthetic */ w a;
    private z b = null;

    public x(w wVar) {
        this.a = wVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public u a(Object... objArr) {
        u uVar;
        this.b = new z();
        if (UtilHelper.g(TiebaApplication.g().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.a.b = d();
            uVar = this.a.b;
            return uVar;
        }
        return null;
    }

    private u d() {
        String a = this.b.a();
        if (this.b.c()) {
            u uVar = new u();
            uVar.a(a);
            return uVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.b != null) {
            this.b.b();
        }
        this.b = null;
        this.a.a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(u uVar) {
        y yVar;
        u uVar2;
        y yVar2;
        y yVar3;
        u uVar3;
        this.a.a = null;
        yVar = this.a.c;
        if (yVar != null) {
            uVar2 = this.a.b;
            if (uVar2 != null) {
                yVar3 = this.a.c;
                uVar3 = this.a.b;
                yVar3.a(uVar3);
                return;
            }
            String d = this.b != null ? this.b.d() : null;
            yVar2 = this.a.c;
            yVar2.a(d);
        }
    }
}
