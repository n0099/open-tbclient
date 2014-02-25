package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ aw a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, boolean z) {
        this.a = awVar;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        com.baidu.tieba.im.groupInfo.v.b(TiebaApplication.A(), this.a.c(), this.b);
        com.baidu.tieba.im.c.a.f().a(this.a.c());
        return null;
    }
}
