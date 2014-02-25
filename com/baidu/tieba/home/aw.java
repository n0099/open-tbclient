package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ au a;
    private volatile ba b;

    private aw(au auVar) {
        this.a = auVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(au auVar, aw awVar) {
        this(auVar);
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
            this.b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/sign");
            ba baVar = this.b;
            str = this.a.a;
            baVar.a("kw", str);
            ba baVar2 = this.b;
            str2 = this.a.b;
            baVar2.a("fid", str2);
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
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        av avVar;
        String str;
        if (this.b != null) {
            this.b.k();
        }
        this.a.c = null;
        super.cancel(true);
        avVar = this.a.d;
        str = this.a.b;
        avVar.a(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SignData signData) {
        av avVar;
        av avVar2;
        String str;
        String str2;
        this.a.c = null;
        if (signData != null || this.b == null) {
            avVar = this.a.d;
            avVar.a(signData);
            return;
        }
        this.a.mErrorCode = this.b.f();
        this.a.mErrorString = this.b.j();
        avVar2 = this.a.d;
        str = this.a.b;
        str2 = this.a.mErrorString;
        avVar2.a(str, str2);
    }
}
