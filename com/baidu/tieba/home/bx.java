package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx extends BdAsyncTask<Object, Integer, SignData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bu f1485a;
    private volatile com.baidu.tieba.util.am b;

    private bx(bu buVar) {
        this.f1485a = buVar;
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
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/forum/sign");
            com.baidu.tieba.util.am amVar = this.b;
            str = this.f1485a.f1484a;
            amVar.a("kw", str);
            com.baidu.tieba.util.am amVar2 = this.b;
            str2 = this.f1485a.b;
            amVar2.a("fid", str2);
            this.b.e(true);
            String l = this.b.l();
            if (!this.b.d() || !this.b.c()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(l);
                str3 = this.f1485a.b;
                signData.setForumId(str3);
                str4 = this.f1485a.f1484a;
                signData.setForumName(str4);
                return signData;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bw bwVar;
        String str;
        if (this.b != null) {
            this.b.j();
        }
        this.f1485a.c = null;
        super.cancel(true);
        bwVar = this.f1485a.d;
        str = this.f1485a.b;
        bwVar.a(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        bw bwVar;
        bw bwVar2;
        String str;
        String str2;
        this.f1485a.c = null;
        if (signData != null || this.b == null) {
            bwVar = this.f1485a.d;
            bwVar.a(signData);
            return;
        }
        this.f1485a.mErrorCode = this.b.e();
        this.f1485a.mErrorString = this.b.i();
        bwVar2 = this.f1485a.d;
        str = this.f1485a.b;
        str2 = this.f1485a.mErrorString;
        bwVar2.a(str, str2);
    }
}
