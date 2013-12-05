package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1608a;
    final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, boolean z) {
        this.b = uVar;
        this.f1608a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        com.baidu.tieba.im.groupInfo.u.b(TiebaApplication.B(), this.b.c(), this.f1608a);
        com.baidu.tieba.im.pushNotify.a.h().a(this.b.c());
        return null;
    }
}
