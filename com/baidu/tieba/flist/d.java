package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.aq;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.square.r f1040a;
    final /* synthetic */ c b;
    private com.baidu.tieba.util.v c;

    private d(c cVar) {
        this.b = cVar;
        this.c = null;
        this.f1040a = new com.baidu.tieba.square.r();
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
        if (this.f1040a != null) {
            eVar = this.b.b;
            int a2 = this.f1040a.a();
            com.baidu.tieba.square.s d = this.f1040a.d();
            String c = this.f1040a.c();
            z = this.b.g;
            eVar.a(true, a2, d, c, z);
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
        com.baidu.adp.lib.cache.q h = com.baidu.tieba.b.a.a().h();
        if (h != null) {
            StringBuilder append = new StringBuilder(String.valueOf(TiebaApplication.E())).append("_");
            str5 = this.b.c;
            str6 = (String) h.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.f1040a.b(str6);
            this.b.g = true;
            c((Object[]) new Integer[0]);
        }
        try {
            this.c = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/forum/seconddir");
            com.baidu.tieba.util.v vVar = this.c;
            str = this.b.c;
            vVar.a("menu_name", str);
            com.baidu.tieba.util.v vVar2 = this.c;
            str2 = this.b.d;
            vVar2.a("menu_type", str2);
            com.baidu.tieba.util.v vVar3 = this.c;
            str3 = this.b.e;
            vVar3.a("menu_id", str3);
            j = this.c.j();
        } catch (Exception e) {
            this.f1040a.a(e.getMessage());
            aq.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (j == null) {
            return this.f1040a;
        }
        if (this.c.c()) {
            this.f1040a.b(j);
            this.b.f = true;
            if (h != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TiebaApplication.E())).append("_");
                str4 = this.b.c;
                h.a(append2.append(str4).append("_dir").toString(), j, Util.MILLSECONDS_OF_DAY);
            }
        } else {
            this.f1040a.a(this.c.g());
            this.b.f = false;
        }
        return this.f1040a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.square.r rVar) {
        boolean z;
        e eVar;
        boolean z2;
        e eVar2;
        boolean z3;
        aq.e("DirMenuTask", "onPost", "start");
        z = this.b.f;
        if (!z) {
            aq.e("DirMenuTask", "onPost", " not ok start");
            eVar2 = this.b.b;
            String c = rVar.c();
            z3 = this.b.g;
            eVar2.a(false, -1, null, c, z3);
            aq.e("DirMenuTask", "onPost", "not ok end");
            return;
        }
        aq.e("DirMenuTask", "onPost", "ok");
        if (rVar.d() != null) {
            eVar = this.b.b;
            int a2 = rVar.a();
            com.baidu.tieba.square.s d = rVar.d();
            String c2 = rVar.c();
            z2 = this.b.g;
            eVar.a(true, a2, d, c2, z2);
        }
        aq.e("DirMenuTask", "onPost", "ok end");
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
