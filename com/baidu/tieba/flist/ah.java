package com.baidu.tieba.flist;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ah extends BdAsyncTask<Void, Void, ForumRankData> {
    final /* synthetic */ ag a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ForumRankData a(Void... voidArr) {
        return ag.a(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForumRankData forumRankData) {
        ForumRankData forumRankData2 = forumRankData;
        ag.a(this.a, null);
        if (ag.b(this.a) != null) {
            ag.b(this.a).a(forumRankData2);
        }
    }

    private ah(ag agVar) {
        this.a = agVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(ag agVar, byte b) {
        this(agVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        ag.a(this.a, null);
    }
}
