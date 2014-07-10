package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Object, Integer, com.baidu.tieba.square.o> {
    com.baidu.tieba.square.o a;
    final /* synthetic */ c b;
    private aq c;

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
            this.c = new aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/seconddir");
            aq aqVar = this.c;
            str = this.b.c;
            aqVar.a("menu_name", str);
            aq aqVar2 = this.c;
            str2 = this.b.d;
            aqVar2.a("menu_type", str2);
            aq aqVar3 = this.c;
            str3 = this.b.e;
            aqVar3.a("menu_id", str3);
            i = this.c.i();
        } catch (Exception e) {
            this.a.a(e.getMessage());
            BdLog.detailException(e);
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
            this.c.g();
            this.c = null;
        }
    }
}
