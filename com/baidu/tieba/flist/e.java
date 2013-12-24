package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.an;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.t> {
    com.baidu.tieba.square.t a;
    final /* synthetic */ c b;
    private an c;

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
        String l;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.s<String> m = com.baidu.tieba.b.a.a().m();
        if (m != null) {
            StringBuilder append = new StringBuilder().append(TiebaApplication.B()).append("_");
            str5 = this.b.c;
            str6 = m.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new an(com.baidu.tieba.data.h.a + "c/f/forum/seconddir");
            an anVar = this.c;
            str = this.b.c;
            anVar.a("menu_name", str);
            an anVar2 = this.c;
            str2 = this.b.d;
            anVar2.a("menu_type", str2);
            an anVar3 = this.c;
            str3 = this.b.e;
            anVar3.a("menu_id", str3);
            l = this.c.l();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (l == null) {
            return this.a;
        }
        if (this.c.c()) {
            this.a.b(l);
            this.b.f = true;
            if (m != null) {
                StringBuilder append2 = new StringBuilder().append(TiebaApplication.B()).append("_");
                str4 = this.b.c;
                m.a(append2.append(str4).append("_dir").toString(), l, 86400000L);
            }
        } else {
            this.a.a(this.c.i());
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
        be.e("DirMenuTask", "onPost", "start");
        z = this.b.f;
        if (!z) {
            be.e("DirMenuTask", "onPost", " not ok start");
            fVar2 = this.b.b;
            String c = tVar.c();
            z3 = this.b.g;
            fVar2.a(false, -1, null, c, z3);
            be.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        be.e("DirMenuTask", "onPost", "ok");
        if (tVar.d() != null) {
            fVar = this.b.b;
            int a = tVar.a();
            com.baidu.tieba.square.z d = tVar.d();
            String c2 = tVar.c();
            z2 = this.b.g;
            fVar.a(true, a, d, c2, z2);
        }
        be.e("DirMenuTask", "onPost", "ok end");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
    }
}
