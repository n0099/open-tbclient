package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Object, Integer, y> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1388a;
    private ad b = null;

    public ab(aa aaVar) {
        this.f1388a = aaVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public y a(Object... objArr) {
        y yVar;
        this.b = new ad();
        if (UtilHelper.i(TiebaApplication.g().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.f1388a.b = d();
            yVar = this.f1388a.b;
            return yVar;
        }
        return null;
    }

    private y d() {
        String a2 = this.b.a();
        if (this.b.c()) {
            y yVar = new y();
            yVar.a(a2);
            return yVar;
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
        this.f1388a.f1387a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(y yVar) {
        ac acVar;
        y yVar2;
        ac acVar2;
        ac acVar3;
        y yVar3;
        this.f1388a.f1387a = null;
        acVar = this.f1388a.c;
        if (acVar != null) {
            yVar2 = this.f1388a.b;
            if (yVar2 != null) {
                acVar3 = this.f1388a.c;
                yVar3 = this.f1388a.b;
                acVar3.a(yVar3);
                return;
            }
            String d = this.b != null ? this.b.d() : null;
            acVar2 = this.f1388a.c;
            acVar2.a(d);
        }
    }
}
