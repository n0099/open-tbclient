package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f838a;
    final /* synthetic */ LabelActivity b;
    private String d;
    private boolean f;
    private com.baidu.tieba.util.u c = null;
    private int e = 1;

    public ab(LabelActivity labelActivity, String str, boolean z, ArrayList arrayList) {
        this.b = labelActivity;
        this.d = null;
        this.f838a = null;
        this.d = str;
        this.f838a = arrayList;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.b.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        com.baidu.tieba.model.aq aqVar;
        com.baidu.tieba.model.aq aqVar2;
        com.baidu.tieba.model.aq aqVar3;
        com.baidu.tieba.model.aq aqVar4;
        com.baidu.tieba.model.aq aqVar5;
        com.baidu.tieba.model.aq aqVar6;
        try {
            this.c = new com.baidu.tieba.util.u(this.d);
            this.c.a(this.f838a);
            aqVar = this.b.q;
            if (aqVar != null) {
                aqVar5 = this.b.q;
                if (aqVar5.i().size() != 0) {
                    aqVar6 = this.b.q;
                    this.c.a("tag_info", aqVar6.h());
                }
            }
            com.baidu.tieba.util.aj.b("begin to get label data...url is " + this.d);
            String k = this.c.k();
            com.baidu.tieba.util.aj.b("end to get label data...");
            if (this.c.d()) {
                aqVar2 = this.b.q;
                if (aqVar2 == null) {
                    this.b.q = new com.baidu.tieba.model.aq();
                }
                aqVar3 = this.b.q;
                aqVar3.a(k);
                if (this.f) {
                    aqVar4 = this.b.q;
                    aqVar4.b(DatabaseService.b(12));
                }
                com.baidu.tieba.util.aj.a(getClass().getName(), "doInBackground", k);
                System.gc();
            }
            if (this.c.e()) {
                this.e = 0;
            } else {
                this.e = 1;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "", "LabelAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        this.b.b(false);
        if (bool.booleanValue() && this.e != 1) {
            this.b.m();
            this.b.c(false);
        } else {
            e();
        }
        this.b.M = null;
        System.gc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.i();
        }
        super.cancel(true);
    }

    private void e() {
        this.b.a(this.c.h());
    }
}
