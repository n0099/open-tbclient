package com.baidu.tieba.editortool;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* loaded from: classes.dex */
class u extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ q a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, String str) {
        this.a = qVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        com.baidu.tbadk.core.util.s.c(new File(this.b));
        return null;
    }
}
