package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.t> {
    com.baidu.tieba.square.t a;
    final /* synthetic */ c b;
    private ax c;

    private e(c cVar) {
        this.b = cVar;
        this.c = null;
        this.a = new com.baidu.tieba.square.t();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        f fVar;
        boolean z;
        super.b((Object[]) numArr);
        if (this.a != null) {
            fVar = this.b.b;
            int a = this.a.a();
            com.baidu.tieba.square.z d = this.a.d();
            String c = this.a.c();
            z = this.b.g;
            fVar.a(true, a, d, c, z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.square.t a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String m;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.s<String> m2 = com.baidu.tieba.b.a.a().m();
        if (m2 != null) {
            StringBuilder append = new StringBuilder().append(TiebaApplication.A()).append("_");
            str5 = this.b.c;
            str6 = m2.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new ax(com.baidu.tieba.data.h.a + "c/f/forum/seconddir");
            ax axVar = this.c;
            str = this.b.c;
            axVar.a("menu_name", str);
            ax axVar2 = this.c;
            str2 = this.b.d;
            axVar2.a("menu_type", str2);
            ax axVar3 = this.c;
            str3 = this.b.e;
            axVar3.a("menu_id", str3);
            m = this.c.m();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (m == null) {
            return this.a;
        }
        if (this.c.d()) {
            this.a.b(m);
            this.b.f = true;
            if (m2 != null) {
                StringBuilder append2 = new StringBuilder().append(TiebaApplication.A()).append("_");
                str4 = this.b.c;
                m2.a(append2.append(str4).append("_dir").toString(), m, 86400000L);
            }
        } else {
            this.a.a(this.c.j());
            this.b.f = false;
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.square.t tVar) {
        boolean z;
        f fVar;
        boolean z2;
        f fVar2;
        boolean z3;
        com.baidu.adp.lib.g.e.e("DirMenuTask", "onPost", "start");
        z = this.b.f;
        if (!z) {
            com.baidu.adp.lib.g.e.e("DirMenuTask", "onPost", " not ok start");
            fVar2 = this.b.b;
            String c = tVar.c();
            z3 = this.b.g;
            fVar2.a(false, -1, null, c, z3);
            com.baidu.adp.lib.g.e.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        com.baidu.adp.lib.g.e.e("DirMenuTask", "onPost", "ok");
        if (tVar.d() != null) {
            fVar = this.b.b;
            int a = tVar.a();
            com.baidu.tieba.square.z d = tVar.d();
            String c2 = tVar.c();
            z2 = this.b.g;
            fVar.a(true, a, d, c2, z2);
        }
        com.baidu.adp.lib.g.e.e("DirMenuTask", "onPost", "ok end");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.k();
            this.c = null;
        }
    }
}
