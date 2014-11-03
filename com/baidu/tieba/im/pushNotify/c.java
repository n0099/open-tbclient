package com.baidu.tieba.im.pushNotify;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String aOn;
    final /* synthetic */ b bhx;
    private final /* synthetic */ String bhy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str, String str2) {
        this.bhx = bVar;
        this.aOn = str;
        this.bhy = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        a am = this.bhx.am(this.aOn, this.bhy);
        if (am == null) {
            return false;
        }
        return Boolean.valueOf(am.isAcceptNotify());
    }
}
