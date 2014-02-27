package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.t> {
    com.baidu.tieba.square.t a;
    final /* synthetic */ c b;
    private ba c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.square.t a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.square.t tVar) {
        boolean z;
        e eVar;
        boolean z2;
        e eVar2;
        boolean z3;
        com.baidu.tieba.square.t tVar2 = tVar;
        com.baidu.adp.lib.util.e.e("DirMenuTask", "onPost", "start");
        z = this.b.f;
        if (!z) {
            com.baidu.adp.lib.util.e.e("DirMenuTask", "onPost", " not ok start");
            eVar2 = this.b.b;
            tVar2.c();
            z3 = this.b.g;
            eVar2.a(false, -1, null, z3);
            com.baidu.adp.lib.util.e.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        com.baidu.adp.lib.util.e.e("DirMenuTask", "onPost", "ok");
        if (tVar2.d() != null) {
            eVar = this.b.b;
            int a = tVar2.a();
            com.baidu.tieba.square.ab d = tVar2.d();
            tVar2.c();
            z2 = this.b.g;
            eVar.a(true, a, d, z2);
        }
        com.baidu.adp.lib.util.e.e("DirMenuTask", "onPost", "ok end");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        e eVar;
        boolean z;
        super.b((Object[]) numArr);
        if (this.a != null) {
            eVar = this.b.b;
            int a = this.a.a();
            com.baidu.tieba.square.ab d = this.a.d();
            this.a.c();
            z = this.b.g;
            eVar.a(true, a, d, z);
        }
    }

    private d(c cVar) {
        this.b = cVar;
        this.c = null;
        this.a = new com.baidu.tieba.square.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(c cVar, byte b) {
        this(cVar);
    }

    private com.baidu.tieba.square.t d() {
        String str;
        String str2;
        String str3;
        String l;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.s<String> m = com.baidu.tieba.c.a.a().m();
        if (m != null) {
            StringBuilder append = new StringBuilder(String.valueOf(TiebaApplication.v())).append("_");
            str5 = this.b.c;
            str6 = m.a(append.append(str5).append("_dir").toString());
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
            l = this.c.l();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (l == null) {
            return this.a;
        }
        if (this.c.c()) {
            this.a.b(l);
            this.b.f = true;
            if (m != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TiebaApplication.v())).append("_");
                str4 = this.b.c;
                m.a(append2.append(str4).append("_dir").toString(), l, 86400000L);
            }
        } else {
            this.a.a(this.c.i());
            this.b.f = false;
        }
        return this.a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
    }
}
