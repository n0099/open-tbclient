package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<String, Integer, com.baidu.tieba.im.data.e> {
    final /* synthetic */ h a;
    private com.baidu.tieba.b.e b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.im.data.e a(String... strArr) {
        int i;
        com.baidu.tieba.im.data.e eVar = null;
        String[] strArr2 = strArr;
        if (this.b == null) {
            this.b = new com.baidu.tieba.b.e();
        }
        String str = strArr2.length > 0 ? strArr2[0] : null;
        String b = this.b.b(str);
        this.a.mErrorString = this.b.g();
        this.a.mErrorCode = this.b.e();
        i = this.a.mErrorCode;
        if (i == 0) {
            eVar = new com.baidu.tieba.im.data.e();
            eVar.a(b);
            eVar.a((str == null || str.equals("")) ? false : true);
        }
        return eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(com.baidu.tieba.im.data.e eVar) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        com.baidu.tieba.im.data.e eVar2 = eVar;
        super.a((i) eVar2);
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(eVar2);
        }
    }

    private i(h hVar) {
        this.a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(h hVar, byte b) {
        this(hVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.a();
        }
    }
}
