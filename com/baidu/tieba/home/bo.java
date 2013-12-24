package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask<String, Integer, bk> {
    final /* synthetic */ bm a;
    private z b = null;

    public bo(bm bmVar) {
        this.a = bmVar;
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
    public bk a(String... strArr) {
        bk bkVar;
        this.b = new z();
        if (UtilHelper.g(TiebaApplication.h().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.a.c = a(strArr[0]);
            bkVar = this.a.c;
            return bkVar;
        }
        return null;
    }

    private bk a(String str) {
        String a = this.b.a(str);
        if (this.b.b()) {
            bk bkVar = new bk();
            bkVar.a(a);
            return bkVar;
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
    public void a(bk bkVar) {
        bn bnVar;
        bk bkVar2;
        bn bnVar2;
        bn bnVar3;
        bk bkVar3;
        this.a.a = false;
        this.a.b = null;
        bnVar = this.a.d;
        if (bnVar != null) {
            bkVar2 = this.a.c;
            if (bkVar2 != null) {
                bnVar3 = this.a.d;
                bkVar3 = this.a.c;
                bnVar3.a(bkVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            bnVar2 = this.a.d;
            bnVar2.a(c);
        }
    }
}
