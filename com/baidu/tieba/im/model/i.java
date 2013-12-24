package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.im.data.e> {
    final /* synthetic */ g a;
    private com.baidu.tieba.a.e b;

    private i(g gVar) {
        this.a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.im.data.e eVar) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((i) eVar);
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(eVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.im.data.e a(String... strArr) {
        int i;
        com.baidu.tieba.im.data.e eVar = null;
        if (this.b == null) {
            this.b = new com.baidu.tieba.a.e();
        }
        String str = strArr.length > 0 ? strArr[0] : null;
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
}
