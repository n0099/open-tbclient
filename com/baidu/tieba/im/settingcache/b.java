package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bEc;
    final /* synthetic */ a bEk;
    private final /* synthetic */ String bEl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bEk = aVar;
        this.bEc = str;
        this.bEl = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aL = this.bEk.aL(this.bEc, this.bEl);
        if (aL == null) {
            return false;
        }
        return Boolean.valueOf(aL.isAcceptNotify());
    }
}
