package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ a bnA;
    private final /* synthetic */ String bnB;
    private final /* synthetic */ String bns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bnA = aVar;
        this.bns = str;
        this.bnB = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aD = this.bnA.aD(this.bns, this.bnB);
        if (aD == null) {
            return false;
        }
        return Boolean.valueOf(aD.isAcceptNotify());
    }
}
