package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1695a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, String str2, boolean z) {
        this.f1695a = str;
        this.b = str2;
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        v.c(this.f1695a, this.b, this.c);
        return null;
    }
}
