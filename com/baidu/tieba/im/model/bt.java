package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bt extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ bs a;
    private String b;
    private long c;
    private o d = new o();

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        String str2 = str;
        super.a((bt) str2);
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(new BasicNameValuePair(String.valueOf(this.c), str2));
        }
    }

    public bt(bs bsVar, String str, long j) {
        this.a = bsVar;
        this.b = str;
        this.c = j;
    }

    private String a() {
        String str;
        try {
            o oVar = this.d;
            return o.a(this.b);
        } catch (Exception e) {
            str = bs.a;
            com.baidu.adp.lib.util.f.b(str, "doInBackground", "errro: " + e.getMessage());
            return null;
        }
    }
}
