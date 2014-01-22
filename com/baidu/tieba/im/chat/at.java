package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ boolean a;
    final /* synthetic */ as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, boolean z) {
        this.b = asVar;
        this.a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        com.baidu.tieba.im.groupInfo.u.b(TiebaApplication.A(), this.b.c(), this.a);
        com.baidu.tieba.im.c.a.h().a(this.b.c());
        return null;
    }
}
