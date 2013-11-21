package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends BdAsyncTask<String, Integer, bp> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1428a;
    private ae b = null;

    public bt(br brVar) {
        this.f1428a = brVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
        this.f1428a.f1427a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bp a(String... strArr) {
        bp bpVar;
        this.b = new ae();
        if (UtilHelper.i(TiebaApplication.g().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.f1428a.c = a(strArr[0]);
            bpVar = this.f1428a.c;
            return bpVar;
        }
        return null;
    }

    private bp a(String str) {
        String a2 = this.b.a(str);
        if (this.b.b()) {
            bp bpVar = new bp();
            bpVar.a(a2);
            return bpVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.b.a();
        this.b = null;
        this.f1428a.b = null;
        this.f1428a.f1427a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bp bpVar) {
        bs bsVar;
        bp bpVar2;
        bs bsVar2;
        bs bsVar3;
        bp bpVar3;
        this.f1428a.f1427a = false;
        this.f1428a.b = null;
        bsVar = this.f1428a.d;
        if (bsVar != null) {
            bpVar2 = this.f1428a.c;
            if (bpVar2 != null) {
                bsVar3 = this.f1428a.d;
                bpVar3 = this.f1428a.c;
                bsVar3.a(bpVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            bsVar2 = this.f1428a.d;
            bsVar2.a(c);
        }
    }
}
