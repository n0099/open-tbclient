package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aq extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ ap a;
    private String b;
    private long c;
    private g d = new g();

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        String str2 = str;
        super.a((aq) str2);
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(new BasicNameValuePair(String.valueOf(this.c), str2));
        }
    }

    public aq(ap apVar, String str, long j) {
        this.a = apVar;
        this.b = str;
        this.c = j;
    }

    private String d() {
        String str;
        try {
            g gVar = this.d;
            return g.a(this.b);
        } catch (Exception e) {
            str = ap.a;
            com.baidu.adp.lib.util.e.b(str, "doInBackground", "errro: " + e.getMessage());
            return null;
        }
    }
}
