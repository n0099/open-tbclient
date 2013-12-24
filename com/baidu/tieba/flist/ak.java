package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Void, Void, ForumRankData> {
    final /* synthetic */ ai a;

    private ak(ai aiVar) {
        this.a = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumRankData a(Void... voidArr) {
        return ai.a(this.a);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        ai.a(this.a, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumRankData forumRankData) {
        ai.a(this.a, null);
        if (ai.b(this.a) != null) {
            ai.c(this.a).a(forumRankData);
        }
    }
}
