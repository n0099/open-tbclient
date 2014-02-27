package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aw extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ au a;
    private volatile ba b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ SignData a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(SignData signData) {
        av avVar;
        av avVar2;
        String str;
        String str2;
        SignData signData2 = signData;
        this.a.c = null;
        if (signData2 == null && this.b != null) {
            this.a.mErrorCode = this.b.e();
            this.a.mErrorString = this.b.i();
            avVar2 = this.a.d;
            str = this.a.b;
            str2 = this.a.mErrorString;
            avVar2.a(str, str2);
            return;
        }
        avVar = this.a.d;
        avVar.a(signData2);
    }

    private aw(au auVar) {
        this.a = auVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(au auVar, byte b) {
        this(auVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
    }

    private SignData d() {
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
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        av avVar;
        String str;
        if (this.b != null) {
            this.b.j();
        }
        this.a.c = null;
        super.cancel(true);
        avVar = this.a.d;
        str = this.a.b;
        avVar.a(str, null);
    }
}
