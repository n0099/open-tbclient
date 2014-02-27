package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ aw a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, boolean z) {
        this.a = awVar;
        this.b = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        com.baidu.tieba.im.groupInfo.v.b(TiebaApplication.v(), this.a.c(), this.b);
        com.baidu.tieba.im.c.a.d().a(this.a.c());
        return null;
    }
}
