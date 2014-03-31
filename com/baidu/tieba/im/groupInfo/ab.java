package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ aa a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, String str, String str2, boolean z) {
        this.a = aaVar;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        this.a.b(this.b, this.c, this.d);
        return null;
    }
}
