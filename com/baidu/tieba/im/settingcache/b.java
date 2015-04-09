package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bnc;
    final /* synthetic */ a bnk;
    private final /* synthetic */ String bnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bnk = aVar;
        this.bnc = str;
        this.bnl = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aE = this.bnk.aE(this.bnc, this.bnl);
        if (aE == null) {
            return false;
        }
        return Boolean.valueOf(aE.isAcceptNotify());
    }
}
