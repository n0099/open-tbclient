package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.t> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.square.t f1253a;
    final /* synthetic */ c b;
    private ap c;

    private e(c cVar) {
        this.b = cVar;
        this.c = null;
        this.f1253a = new com.baidu.tieba.square.t();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        f fVar;
        boolean z;
        super.b((Object[]) numArr);
        if (this.f1253a != null) {
            fVar = this.b.b;
            int a2 = this.f1253a.a();
            com.baidu.tieba.square.z d = this.f1253a.d();
            String c = this.f1253a.c();
            z = this.b.g;
            fVar.a(true, a2, d, c, z);
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
        com.baidu.adp.lib.cache.s<String> j = com.baidu.tieba.b.a.a().j();
        if (j != null) {
            StringBuilder append = new StringBuilder().append(TiebaApplication.A()).append("_");
            str5 = this.b.c;
            str6 = j.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.f1253a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new ap(com.baidu.tieba.data.h.f1201a + "c/f/forum/seconddir");
            ap apVar = this.c;
            str = this.b.c;
            apVar.a("menu_name", str);
            ap apVar2 = this.c;
            str2 = this.b.d;
            apVar2.a("menu_type", str2);
            ap apVar3 = this.c;
            str3 = this.b.e;
            apVar3.a("menu_id", str3);
            l = this.c.l();
        } catch (Exception e) {
            this.f1253a.a(e.getMessage());
            bg.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (l == null) {
            return this.f1253a;
        }
        if (this.c.c()) {
            this.f1253a.b(l);
            this.b.f = true;
            if (j != null) {
                StringBuilder append2 = new StringBuilder().append(TiebaApplication.A()).append("_");
                str4 = this.b.c;
                j.a(append2.append(str4).append("_dir").toString(), l, Util.MILLSECONDS_OF_DAY);
            }
        } else {
            this.f1253a.a(this.c.i());
            this.b.f = false;
        }
        return this.f1253a;
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
        bg.e("DirMenuTask", "onPost", "start");
        z = this.b.f;
        if (!z) {
            bg.e("DirMenuTask", "onPost", " not ok start");
            fVar2 = this.b.b;
            String c = tVar.c();
            z3 = this.b.g;
            fVar2.a(false, -1, null, c, z3);
            bg.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        bg.e("DirMenuTask", "onPost", "ok");
        if (tVar.d() != null) {
            fVar = this.b.b;
            int a2 = tVar.a();
            com.baidu.tieba.square.z d = tVar.d();
            String c2 = tVar.c();
            z2 = this.b.g;
            fVar.a(true, a2, d, c2, z2);
        }
        bg.e("DirMenuTask", "onPost", "ok end");
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
