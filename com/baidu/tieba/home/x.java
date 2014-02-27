package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends BdAsyncTask<Object, Integer, u> {
    final /* synthetic */ w a;
    private z b = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ u a(Object... objArr) {
        u uVar;
        u uVar2 = null;
        this.b = new z();
        if (UtilHelper.h(TiebaApplication.g().b().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            w wVar = this.a;
            String a = this.b.a();
            if (this.b.c()) {
                uVar2 = new u();
                uVar2.a(a);
            }
            wVar.b = uVar2;
            uVar = this.a.b;
            return uVar;
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(u uVar) {
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

    public x(w wVar) {
        this.a = wVar;
        setPriority(3);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        if (this.b != null) {
            this.b.b();
        }
        this.b = null;
        this.a.a = null;
    }
}
