package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Void, Void, ForumRankData> {
    final /* synthetic */ ac a;

    private ad(ac acVar) {
        this.a = acVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ac acVar, ad adVar) {
        this(acVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ForumRankData doInBackground(Void... voidArr) {
        return ac.a(this.a);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        ac.a(this.a, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForumRankData forumRankData) {
        ac.a(this.a, null);
        if (ac.b(this.a) != null) {
            ac.b(this.a).a(forumRankData);
        }
    }
}
