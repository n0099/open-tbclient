package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ ap a;
    private String b;
    private long c;
    private g d = new g();

    public aq(ap apVar, String str, long j) {
        this.a = apVar;
        this.b = str;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        try {
            return this.d.a(this.b);
        } catch (Exception e) {
            str = ap.a;
            com.baidu.adp.lib.g.e.b(str, "doInBackground", "errro: " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((aq) str);
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(new BasicNameValuePair(String.valueOf(this.c), str));
        }
    }
}
