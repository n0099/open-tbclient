package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ bw a;
    private volatile com.baidu.tieba.util.at b;

    private bz(bw bwVar) {
        this.a = bwVar;
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
            this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/c/forum/sign");
            com.baidu.tieba.util.at atVar = this.b;
            str = this.a.a;
            atVar.a("kw", str);
            com.baidu.tieba.util.at atVar2 = this.b;
            str2 = this.a.b;
            atVar2.a("fid", str2);
            this.b.e(true);
            String l = this.b.l();
            if (!this.b.d() || !this.b.c()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(l);
                str3 = this.a.b;
                signData.setForumId(str3);
                str4 = this.a.a;
                signData.setForumName(str4);
                return signData;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        by byVar;
        String str;
        if (this.b != null) {
            this.b.j();
        }
        this.a.c = null;
        super.cancel(true);
        byVar = this.a.d;
        str = this.a.b;
        byVar.a(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        by byVar;
        by byVar2;
        String str;
        String str2;
        this.a.c = null;
        if (signData != null || this.b == null) {
            byVar = this.a.d;
            byVar.a(signData);
            return;
        }
        this.a.mErrorCode = this.b.e();
        this.a.mErrorString = this.b.i();
        byVar2 = this.a.d;
        str = this.a.b;
        str2 = this.a.mErrorString;
        byVar2.a(str, str2);
    }
}
