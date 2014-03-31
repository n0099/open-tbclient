package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.t> {
    com.baidu.tieba.square.t a;
    final /* synthetic */ c b;
    private ak c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tieba.square.t a(Object... objArr) {
        return a();
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
        com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "start");
        z = this.b.f;
        if (!z) {
            com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", " not ok start");
            eVar2 = this.b.b;
            tVar2.c();
            z3 = this.b.g;
            eVar2.a(false, -1, null, z3);
            com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "ok");
        if (tVar2.d() != null) {
            eVar = this.b.b;
            int a = tVar2.a();
            com.baidu.tieba.square.ab d = tVar2.d();
            tVar2.c();
            z2 = this.b.g;
            eVar.a(true, a, d, z2);
        }
        com.baidu.adp.lib.util.f.e("DirMenuTask", "onPost", "ok end");
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

    private com.baidu.tieba.square.t a() {
        String str;
        String str2;
        String str3;
        String i;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.s<String> m = com.baidu.tbadk.core.c.b.a().m();
        if (m != null) {
            StringBuilder append = new StringBuilder(String.valueOf(TbadkApplication.E())).append("_");
            str5 = this.b.c;
            str6 = m.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/seconddir");
            ak akVar = this.c;
            str = this.b.c;
            akVar.a("menu_name", str);
            ak akVar2 = this.c;
            str2 = this.b.d;
            akVar2.a("menu_type", str2);
            ak akVar3 = this.c;
            str3 = this.b.e;
            akVar3.a("menu_id", str3);
            i = this.c.i();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (i == null) {
            return this.a;
        }
        if (this.c.a().b().b()) {
            this.a.b(i);
            this.b.f = true;
            if (m != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TbadkApplication.E())).append("_");
                str4 = this.b.c;
                m.a(append2.append(str4).append("_dir").toString(), i, 86400000L);
            }
        } else {
            this.a.a(this.c.f());
            this.b.f = false;
        }
        return this.a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
    }
}
