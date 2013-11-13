package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Void, Void, ForumRankData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f1245a;

    private ak(ai aiVar) {
        this.f1245a = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumRankData a(Void... voidArr) {
        return ai.a(this.f1245a);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        ai.a(this.f1245a, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumRankData forumRankData) {
        ai.a(this.f1245a, null);
        if (ai.b(this.f1245a) != null) {
            ai.c(this.f1245a).a(forumRankData);
        }
    }
}
