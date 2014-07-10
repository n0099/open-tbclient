package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ by a;
    private String b;
    private long c;
    private o d = new o();

    public bz(by byVar, String str, long j) {
        this.a = byVar;
        this.b = str;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        try {
            return this.d.a(this.b);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute(str);
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(new BasicNameValuePair(String.valueOf(this.c), str));
        }
    }
}
