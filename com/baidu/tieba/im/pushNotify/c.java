package com.baidu.tieba.im.pushNotify;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String aNZ;
    final /* synthetic */ b bhj;
    private final /* synthetic */ String bhk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str, String str2) {
        this.bhj = bVar;
        this.aNZ = str;
        this.bhk = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        a am = this.bhj.am(this.aNZ, this.bhk);
        if (am == null) {
            return false;
        }
        return Boolean.valueOf(am.isAcceptNotify());
    }
}
