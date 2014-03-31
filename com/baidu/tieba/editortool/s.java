package com.baidu.tieba.editortool;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ o a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, String str) {
        this.a = oVar;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        com.baidu.tbadk.core.util.w.c(new File(this.b));
        return null;
    }
}
