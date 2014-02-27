package com.baidu.tieba.editortool;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ g a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, String str) {
        this.a = gVar;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        com.baidu.tieba.util.af.c(new File(this.b));
        return null;
    }
}
