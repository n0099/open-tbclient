package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bmM;
    final /* synthetic */ a bmU;
    private final /* synthetic */ String bmV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bmU = aVar;
        this.bmM = str;
        this.bmV = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aE = this.bmU.aE(this.bmM, this.bmV);
        if (aE == null) {
            return false;
        }
        return Boolean.valueOf(aE.isAcceptNotify());
    }
}
