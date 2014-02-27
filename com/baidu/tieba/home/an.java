package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an extends BdAsyncTask<String, Integer, aj> {
    final /* synthetic */ al a;
    private aa b = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ aj a(String... strArr) {
        aj ajVar;
        aj ajVar2 = null;
        String[] strArr2 = strArr;
        this.b = new aa();
        if (UtilHelper.h(TiebaApplication.g().b().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            al alVar = this.a;
            String a = this.b.a(strArr2[0]);
            if (this.b.b()) {
                ajVar2 = new aj();
                ajVar2.a(a);
            }
            alVar.c = ajVar2;
            ajVar = this.a.c;
            return ajVar;
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(aj ajVar) {
        am amVar;
        aj ajVar2;
        am amVar2;
        am amVar3;
        aj ajVar3;
        this.a.a = false;
        this.a.b = null;
        amVar = this.a.d;
        if (amVar != null) {
            ajVar2 = this.a.c;
            if (ajVar2 != null) {
                amVar3 = this.a.d;
                ajVar3 = this.a.c;
                amVar3.a(ajVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            amVar2 = this.a.d;
            amVar2.a(c);
        }
    }

    public an(al alVar) {
        this.a = alVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        super.b();
        this.a.a = true;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        this.b.a();
        this.b = null;
        this.a.b = null;
        this.a.a = false;
    }
}
