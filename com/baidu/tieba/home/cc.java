package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc extends BdAsyncTask<Object, Integer, SignData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bz f1445a;
    private volatile com.baidu.tieba.util.ap b;

    private cc(bz bzVar) {
        this.f1445a = bzVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public SignData a(Object... objArr) {
        SignData signData;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/forum/sign");
            com.baidu.tieba.util.ap apVar = this.b;
            str = this.f1445a.f1443a;
            apVar.a("kw", str);
            com.baidu.tieba.util.ap apVar2 = this.b;
            str2 = this.f1445a.b;
            apVar2.a("fid", str2);
            this.b.e(true);
            String j = this.b.j();
            if (!this.b.d() || !this.b.c()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(j);
                str3 = this.f1445a.b;
                signData.setForumId(str3);
                str4 = this.f1445a.f1443a;
                signData.setForumName(str4);
                return signData;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        cb cbVar;
        String str;
        if (this.b != null) {
            this.b.h();
        }
        this.f1445a.c = null;
        super.cancel(true);
        cbVar = this.f1445a.d;
        str = this.f1445a.b;
        cbVar.a(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        cb cbVar;
        cb cbVar2;
        String str;
        String str2;
        this.f1445a.c = null;
        if (signData != null || this.b == null) {
            cbVar = this.f1445a.d;
            cbVar.a(signData);
            return;
        }
        this.f1445a.mErrorCode = this.b.e();
        this.f1445a.mErrorString = this.b.g();
        cbVar2 = this.f1445a.d;
        str = this.f1445a.b;
        str2 = this.f1445a.mErrorString;
        cbVar2.a(str, str2);
    }
}
