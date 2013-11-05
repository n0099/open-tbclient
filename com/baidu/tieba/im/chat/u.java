package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1471a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, boolean z) {
        this.b = tVar;
        this.f1471a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        com.baidu.tieba.im.groupInfo.v.b(TiebaApplication.C(), this.b.c(), this.f1471a);
        com.baidu.tieba.im.pushNotify.a.g().a(this.b.c());
        return null;
    }
}
