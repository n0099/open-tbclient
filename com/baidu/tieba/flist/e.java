package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.r> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.square.r f1190a;
    final /* synthetic */ c b;
    private ag c;

    private e(c cVar) {
        this.b = cVar;
        this.c = null;
        this.f1190a = new com.baidu.tieba.square.r();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        f fVar;
        boolean z;
        super.b((Object[]) numArr);
        if (this.f1190a != null) {
            fVar = this.b.b;
            int a2 = this.f1190a.a();
            com.baidu.tieba.square.s d = this.f1190a.d();
            String c = this.f1190a.c();
            z = this.b.g;
            fVar.a(true, a2, d, c, z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.square.r a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String j;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.s<String> i = com.baidu.tieba.b.a.a().i();
        if (i != null) {
            StringBuilder append = new StringBuilder().append(TiebaApplication.C()).append("_");
            str5 = this.b.c;
            str6 = i.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.f1190a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new ag(com.baidu.tieba.data.h.f1165a + "c/f/forum/seconddir");
            ag agVar = this.c;
            str = this.b.c;
            agVar.a("menu_name", str);
            ag agVar2 = this.c;
            str2 = this.b.d;
            agVar2.a("menu_type", str2);
            ag agVar3 = this.c;
            str3 = this.b.e;
            agVar3.a("menu_id", str3);
            j = this.c.j();
        } catch (Exception e) {
            this.f1190a.a(e.getMessage());
            be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (j == null) {
            return this.f1190a;
        }
        if (this.c.c()) {
            this.f1190a.b(j);
            this.b.f = true;
            if (i != null) {
                StringBuilder append2 = new StringBuilder().append(TiebaApplication.C()).append("_");
                str4 = this.b.c;
                i.a(append2.append(str4).append("_dir").toString(), j, Util.MILLSECONDS_OF_DAY);
            }
        } else {
            this.f1190a.a(this.c.g());
            this.b.f = false;
        }
        return this.f1190a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.square.r rVar) {
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
            String c = rVar.c();
            z3 = this.b.g;
            fVar2.a(false, -1, null, c, z3);
            be.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        be.e("DirMenuTask", "onPost", "ok");
        if (rVar.d() != null) {
            fVar = this.b.b;
            int a2 = rVar.a();
            com.baidu.tieba.square.s d = rVar.d();
            String c2 = rVar.c();
            z2 = this.b.g;
            fVar.a(true, a2, d, c2, z2);
        }
        be.e("DirMenuTask", "onPost", "ok end");
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
