package com.baidu.tieba.album;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, List<a>> {
    private final m apS;
    final /* synthetic */ e apT;

    public f(e eVar, m mVar) {
        this.apT = eVar;
        this.apS = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public List<a> doInBackground(Object... objArr) {
        List<a> BG;
        BG = this.apT.BG();
        return BG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.apS != null) {
            this.apS.jz();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(List<a> list) {
        super.onPostExecute(list);
        if (this.apS != null) {
            this.apS.C(list);
        }
    }
}
