package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.bd;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f1811a;
    private String b;
    private long c;
    private e d = new e();

    public ad(ac acVar, String str, long j) {
        this.f1811a = acVar;
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
            str = ac.f1810a;
            bd.b(str, "doInBackground", "errro: " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((ad) str);
        gVar = this.f1811a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1811a.mLoadDataCallBack;
            gVar2.a(new BasicNameValuePair(String.valueOf(this.c), str));
        }
    }
}
