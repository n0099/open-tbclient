package com.baidu.tieba.im.friend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
final class ag extends BdAsyncTask<String, Integer, com.baidu.tieba.im.data.d> {
    final /* synthetic */ af a;
    private a b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.im.data.d a(String... strArr) {
        com.baidu.tieba.im.data.d dVar = null;
        String[] strArr2 = strArr;
        if (this.b == null) {
            this.b = new a();
        }
        String str = strArr2.length > 0 ? strArr2[0] : null;
        String b = this.b.b(str);
        af.a(this.a, this.b.g());
        af.a(this.a, this.b.e());
        if (af.b(this.a) == 0) {
            dVar = new com.baidu.tieba.im.data.d();
            dVar.a(b);
            dVar.a((str == null || str.equals("")) ? false : true);
        }
        return dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(com.baidu.tieba.im.data.d dVar) {
        com.baidu.tieba.im.data.d dVar2 = dVar;
        super.a((ag) dVar2);
        if (af.a(this.a) != null) {
            af.a(this.a).a(dVar2);
        }
    }

    private ag(af afVar) {
        this.a = afVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(af afVar, byte b) {
        this(afVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.a();
        }
    }
}
