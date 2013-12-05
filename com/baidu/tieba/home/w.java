package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<Object, Integer, t> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f1508a;
    private y b = null;

    public w(v vVar) {
        this.f1508a = vVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public t a(Object... objArr) {
        t tVar;
        this.b = new y();
        if (UtilHelper.g(TiebaApplication.h().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.f1508a.b = d();
            tVar = this.f1508a.b;
            return tVar;
        }
        return null;
    }

    private t d() {
        String a2 = this.b.a();
        if (this.b.c()) {
            t tVar = new t();
            tVar.a(a2);
            return tVar;
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
        this.f1508a.f1507a = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(t tVar) {
        x xVar;
        t tVar2;
        x xVar2;
        x xVar3;
        t tVar3;
        this.f1508a.f1507a = null;
        xVar = this.f1508a.c;
        if (xVar != null) {
            tVar2 = this.f1508a.b;
            if (tVar2 != null) {
                xVar3 = this.f1508a.c;
                tVar3 = this.f1508a.b;
                xVar3.a(tVar3);
                return;
            }
            String d = this.b != null ? this.b.d() : null;
            xVar2 = this.f1508a.c;
            xVar2.a(d);
        }
    }
}
