package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends BdAsyncTask<String, Integer, bl> {
    final /* synthetic */ bn a;
    private aa b = null;

    public bp(bn bnVar) {
        this.a = bnVar;
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
    public bl a(String... strArr) {
        bl blVar;
        this.b = new aa();
        if (UtilHelper.g(TiebaApplication.g().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.a.c = a(strArr[0]);
            blVar = this.a.c;
            return blVar;
        }
        return null;
    }

    private bl a(String str) {
        String a = this.b.a(str);
        if (this.b.b()) {
            bl blVar = new bl();
            blVar.a(a);
            return blVar;
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
    public void a(bl blVar) {
        bo boVar;
        bl blVar2;
        bo boVar2;
        bo boVar3;
        bl blVar3;
        this.a.a = false;
        this.a.b = null;
        boVar = this.a.d;
        if (boVar != null) {
            blVar2 = this.a.c;
            if (blVar2 != null) {
                boVar3 = this.a.d;
                blVar3 = this.a.c;
                boVar3.a(blVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            boVar2 = this.a.d;
            boVar2.a(c);
        }
    }
}
