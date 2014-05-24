package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ bz a;
    private String b;
    private long c;
    private q d = new q();

    public ca(bz bzVar, String str, long j) {
        this.a = bzVar;
        this.b = str;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String str;
        try {
            return this.d.a(this.b);
        } catch (Exception e) {
            str = bz.a;
            BdLog.e(str, "doInBackground", "errro: " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.adp.base.e eVar;
        com.baidu.adp.base.e eVar2;
        super.onPostExecute(str);
        eVar = this.a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.a.mLoadDataCallBack;
            eVar2.a(new BasicNameValuePair(String.valueOf(this.c), str));
        }
    }
}
