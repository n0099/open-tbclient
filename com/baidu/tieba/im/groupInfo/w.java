package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, String str2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        v.c(this.a, this.b, this.c);
        return null;
    }
}
