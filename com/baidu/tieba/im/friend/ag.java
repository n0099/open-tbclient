package com.baidu.tieba.im.friend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class ag extends BdAsyncTask<String, Integer, com.baidu.tieba.im.data.f> {
    final /* synthetic */ af a;
    private a b;

    private ag(af afVar) {
        this.a = afVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(af afVar, ag agVar) {
        this(afVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.im.data.f fVar) {
        super.onPostExecute(fVar);
        if (af.a(this.a) != null) {
            af.a(this.a).a(fVar);
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
    /* renamed from: a */
    public com.baidu.tieba.im.data.f doInBackground(String... strArr) {
        com.baidu.tieba.im.data.f fVar = null;
        if (this.b == null) {
            this.b = new a();
        }
        String str = strArr.length > 0 ? strArr[0] : null;
        String b = this.b.b(str);
        af.a(this.a, this.b.g());
        af.a(this.a, this.b.e());
        if (af.b(this.a) == 0) {
            fVar = new com.baidu.tieba.im.data.f();
            fVar.a(b);
            fVar.a((str == null || str.equals("")) ? false : true);
        }
        return fVar;
    }
}
