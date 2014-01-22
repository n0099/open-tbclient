package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ bw a;
    private volatile com.baidu.tieba.util.ax b;

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
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/c/forum/sign");
            com.baidu.tieba.util.ax axVar = this.b;
            str = this.a.a;
            axVar.a("kw", str);
            com.baidu.tieba.util.ax axVar2 = this.b;
            str2 = this.a.b;
            axVar2.a("fid", str2);
            this.b.e(true);
            String m = this.b.m();
            if (!this.b.e() || !this.b.d()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(m);
                str3 = this.a.b;
                signData.setForumId(str3);
                str4 = this.a.a;
                signData.setForumName(str4);
                return signData;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
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
            this.b.k();
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
        this.a.mErrorCode = this.b.f();
        this.a.mErrorString = this.b.j();
        byVar2 = this.a.d;
        str = this.a.b;
        str2 = this.a.mErrorString;
        byVar2.a(str, str2);
    }
}
