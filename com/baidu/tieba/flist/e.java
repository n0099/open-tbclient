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
    com.baidu.tieba.square.t f1248a;
    final /* synthetic */ c b;
    private ap c;

    private e(c cVar) {
        this.b = cVar;
        this.c = null;
        this.f1248a = new com.baidu.tieba.square.t();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        f fVar;
        boolean z;
        super.b((Object[]) numArr);
        if (this.f1248a != null) {
            fVar = this.b.b;
            int a2 = this.f1248a.a();
            com.baidu.tieba.square.z d = this.f1248a.d();
            String c = this.f1248a.c();
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
        String j;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.s<String> j2 = com.baidu.tieba.b.a.a().j();
        if (j2 != null) {
            StringBuilder append = new StringBuilder().append(TiebaApplication.A()).append("_");
            str5 = this.b.c;
            str6 = j2.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.f1248a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new ap(com.baidu.tieba.data.h.f1196a + "c/f/forum/seconddir");
            ap apVar = this.c;
            str = this.b.c;
            apVar.a("menu_name", str);
            ap apVar2 = this.c;
            str2 = this.b.d;
            apVar2.a("menu_type", str2);
            ap apVar3 = this.c;
            str3 = this.b.e;
            apVar3.a("menu_id", str3);
            j = this.c.j();
        } catch (Exception e) {
            this.f1248a.a(e.getMessage());
            bg.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (j == null) {
            return this.f1248a;
        }
        if (this.c.c()) {
            this.f1248a.b(j);
            this.b.f = true;
            if (j2 != null) {
                StringBuilder append2 = new StringBuilder().append(TiebaApplication.A()).append("_");
                str4 = this.b.c;
                j2.a(append2.append(str4).append("_dir").toString(), j, Util.MILLSECONDS_OF_DAY);
            }
        } else {
            this.f1248a.a(this.c.g());
            this.b.f = false;
        }
        return this.f1248a;
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
            this.c.h();
            this.c = null;
        }
    }
}
