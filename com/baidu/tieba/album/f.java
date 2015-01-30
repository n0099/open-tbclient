package com.baidu.tieba.album;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, List<a>> {
    private final m apV;
    final /* synthetic */ e apW;

    public f(e eVar, m mVar) {
        this.apW = eVar;
        this.apV = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public List<a> doInBackground(Object... objArr) {
        List<a> BM;
        BM = this.apW.BM();
        return BM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.apV != null) {
            this.apV.jG();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(List<a> list) {
        super.onPostExecute(list);
        if (this.apV != null) {
            this.apV.C(list);
        }
    }
}
