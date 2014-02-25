package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask<String, Integer, aj> {
    final /* synthetic */ al a;
    private aa b = null;

    public an(al alVar) {
        this.a = alVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
        this.a.a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public aj a(String... strArr) {
        aj ajVar;
        this.b = new aa();
        if (UtilHelper.h(TiebaApplication.g().b().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.a.c = a(strArr[0]);
            ajVar = this.a.c;
            return ajVar;
        }
        return null;
    }

    private aj a(String str) {
        String a = this.b.a(str);
        if (this.b.b()) {
            aj ajVar = new aj();
            ajVar.a(a);
            return ajVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.b.a();
        this.b = null;
        this.a.b = null;
        this.a.a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(aj ajVar) {
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
}
