package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Void, Void, ForumRankData> {
    final /* synthetic */ ag a;

    private ah(ag agVar) {
        this.a = agVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(ag agVar, ah ahVar) {
        this(agVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ForumRankData doInBackground(Void... voidArr) {
        return ag.a(this.a);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        ag.a(this.a, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForumRankData forumRankData) {
        ag.a(this.a, null);
        if (ag.b(this.a) != null) {
            ag.b(this.a).a(forumRankData);
        }
    }
}
