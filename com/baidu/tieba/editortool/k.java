package com.baidu.tieba.editortool;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.af;
import java.io.File;
/* loaded from: classes.dex */
class k extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ g a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, String str) {
        this.a = gVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        af.c(new File(this.b));
        return null;
    }
}
