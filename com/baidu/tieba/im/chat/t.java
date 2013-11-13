package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1562a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, boolean z) {
        this.b = sVar;
        this.f1562a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        com.baidu.tieba.im.groupInfo.v.b(TiebaApplication.A(), this.b.c(), this.f1562a);
        com.baidu.tieba.im.pushNotify.a.g().a(this.b.c());
        return null;
    }
}
