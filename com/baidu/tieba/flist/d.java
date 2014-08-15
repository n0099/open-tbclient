package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.o> {
    com.baidu.tieba.square.o a;
    final /* synthetic */ c b;
    private ae c;

    private d(c cVar) {
        this.b = cVar;
        this.c = null;
        this.a = new com.baidu.tieba.square.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(c cVar, d dVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        e eVar;
        boolean z;
        super.onProgressUpdate(numArr);
        if (this.a != null) {
            eVar = this.b.b;
            int a = this.a.a();
            com.baidu.tieba.square.w d = this.a.d();
            String c = this.a.c();
            z = this.b.g;
            eVar.a(true, a, d, c, z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.square.o doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String h;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.my_posts");
        if (b != null) {
            StringBuilder append = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
            str5 = this.b.c;
            str6 = b.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.a.b(str6);
            this.b.g = true;
            publishProgress(new Integer[0]);
        }
        try {
            this.c = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/seconddir");
            ae aeVar = this.c;
            str = this.b.c;
            aeVar.a("menu_name", str);
            ae aeVar2 = this.c;
            str2 = this.b.d;
            aeVar2.a("menu_type", str2);
            ae aeVar3 = this.c;
            str3 = this.b.e;
            aeVar3.a("menu_id", str3);
            h = this.c.h();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            BdLog.detailException(e);
        }
        if (h == null) {
            return this.a;
        }
        if (this.c.a().b().b()) {
            this.a.b(h);
            this.b.f = true;
            if (b != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
                str4 = this.b.c;
                b.a(append2.append(str4).append("_dir").toString(), h, 86400000L);
            }
        } else {
            this.a.a(this.c.e());
            this.b.f = false;
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.square.o oVar) {
        boolean z;
        e eVar;
        boolean z2;
        e eVar2;
        boolean z3;
        z = this.b.f;
        if (!z) {
            eVar2 = this.b.b;
            String c = oVar.c();
            z3 = this.b.g;
            eVar2.a(false, -1, null, c, z3);
        } else if (oVar.d() != null) {
            eVar = this.b.b;
            int a = oVar.a();
            com.baidu.tieba.square.w d = oVar.d();
            String c2 = oVar.c();
            z2 = this.b.g;
            eVar.a(true, a, d, c2, z2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.f();
            this.c = null;
        }
    }
}
