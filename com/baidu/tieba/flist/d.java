package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.t> {
    com.baidu.tieba.square.t a;
    final /* synthetic */ c b;
    private ba c;

    private d(c cVar) {
        this.b = cVar;
        this.c = null;
        this.a = new com.baidu.tieba.square.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(c cVar, d dVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        e eVar;
        boolean z;
        super.b((Object[]) numArr);
        if (this.a != null) {
            eVar = this.b.b;
            int a = this.a.a();
            com.baidu.tieba.square.ab d = this.a.d();
            String c = this.a.c();
            z = this.b.g;
            eVar.a(true, a, d, c, z);
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
        com.baidu.adp.lib.cache.s<String> m2 = com.baidu.tieba.c.a.a().m();
        if (m2 != null) {
            StringBuilder append = new StringBuilder(String.valueOf(TiebaApplication.A())).append("_");
            str5 = this.b.c;
            str6 = m2.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/seconddir");
            ba baVar = this.c;
            str = this.b.c;
            baVar.a("menu_name", str);
            ba baVar2 = this.c;
            str2 = this.b.d;
            baVar2.a("menu_type", str2);
            ba baVar3 = this.c;
            str3 = this.b.e;
            baVar3.a("menu_id", str3);
            m = this.c.m();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (m == null) {
            return this.a;
        }
        if (this.c.d()) {
            this.a.b(m);
            this.b.f = true;
            if (m2 != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TiebaApplication.A())).append("_");
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
        e eVar;
        boolean z2;
        e eVar2;
        boolean z3;
        com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "start");
        z = this.b.f;
        if (!z) {
            com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", " not ok start");
            eVar2 = this.b.b;
            String c = tVar.c();
            z3 = this.b.g;
            eVar2.a(false, -1, null, c, z3);
            com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "ok");
        if (tVar.d() != null) {
            eVar = this.b.b;
            int a = tVar.a();
            com.baidu.tieba.square.ab d = tVar.d();
            String c2 = tVar.c();
            z2 = this.b.g;
            eVar.a(true, a, d, c2, z2);
        }
        com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "ok end");
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
