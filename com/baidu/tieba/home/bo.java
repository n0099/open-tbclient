package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask<String, Integer, bk> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1478a;
    private z b = null;

    public bo(bm bmVar) {
        this.f1478a = bmVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
        this.f1478a.f1477a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bk a(String... strArr) {
        bk bkVar;
        this.b = new z();
        if (UtilHelper.g(TiebaApplication.h().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.f1478a.c = a(strArr[0]);
            bkVar = this.f1478a.c;
            return bkVar;
        }
        return null;
    }

    private bk a(String str) {
        String a2 = this.b.a(str);
        if (this.b.b()) {
            bk bkVar = new bk();
            bkVar.a(a2);
            return bkVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.b.a();
        this.b = null;
        this.f1478a.b = null;
        this.f1478a.f1477a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bk bkVar) {
        bn bnVar;
        bk bkVar2;
        bn bnVar2;
        bn bnVar3;
        bk bkVar3;
        this.f1478a.f1477a = false;
        this.f1478a.b = null;
        bnVar = this.f1478a.d;
        if (bnVar != null) {
            bkVar2 = this.f1478a.c;
            if (bkVar2 != null) {
                bnVar3 = this.f1478a.d;
                bkVar3 = this.f1478a.c;
                bnVar3.a(bkVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            bnVar2 = this.f1478a.d;
            bnVar2.a(c);
        }
    }
}
