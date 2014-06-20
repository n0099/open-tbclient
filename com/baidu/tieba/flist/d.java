package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.t> {
    com.baidu.tieba.square.t a;
    final /* synthetic */ c b;
    private an c;

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
    public void onProgressUpdate(Integer... numArr) {
        e eVar;
        boolean z;
        super.onProgressUpdate(numArr);
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
    /* renamed from: a */
    public com.baidu.tieba.square.t doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String i;
        String str4;
        String str5;
        String str6 = null;
        com.baidu.adp.lib.cache.s<String> p = com.baidu.tbadk.core.a.b.a().p();
        if (p != null) {
            StringBuilder append = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
            str5 = this.b.c;
            str6 = p.a(append.append(str5).append("_dir").toString());
        }
        if (str6 != null) {
            this.a.b(str6);
            this.b.g = true;
            publishProgress(new Integer[0]);
        }
        try {
            this.c = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/seconddir");
            an anVar = this.c;
            str = this.b.c;
            anVar.a("menu_name", str);
            an anVar2 = this.c;
            str2 = this.b.d;
            anVar2.a("menu_type", str2);
            an anVar3 = this.c;
            str3 = this.b.e;
            anVar3.a("menu_id", str3);
            i = this.c.i();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (i == null) {
            return this.a;
        }
        if (this.c.a().b().b()) {
            this.a.b(i);
            this.b.f = true;
            if (p != null) {
                StringBuilder append2 = new StringBuilder(String.valueOf(TbadkApplication.getCurrentAccount())).append("_");
                str4 = this.b.c;
                p.a(append2.append(str4).append("_dir").toString(), i, 86400000L);
            }
        } else {
            this.a.a(this.c.f());
            this.b.f = false;
        }
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.square.t tVar) {
        boolean z;
        e eVar;
        boolean z2;
        e eVar2;
        boolean z3;
        BdLog.d("DirMenuTask", "onPost", com.baidu.tbadk.core.frameworkData.a.START);
        z = this.b.f;
        if (!z) {
            BdLog.d("DirMenuTask", "onPost", " not ok start");
            eVar2 = this.b.b;
            String c = tVar.c();
            z3 = this.b.g;
            eVar2.a(false, -1, null, c, z3);
            BdLog.d("DirMenuTask", "onPost", "not ok end");
            return;
        }
        BdLog.d("DirMenuTask", "onPost", "ok");
        if (tVar.d() != null) {
            eVar = this.b.b;
            int a = tVar.a();
            com.baidu.tieba.square.ab d = tVar.d();
            String c2 = tVar.c();
            z2 = this.b.g;
            eVar.a(true, a, d, c2, z2);
        }
        BdLog.d("DirMenuTask", "onPost", "ok end");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
    }
}
