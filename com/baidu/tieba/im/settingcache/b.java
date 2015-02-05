package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String boO;
    final /* synthetic */ a boW;
    private final /* synthetic */ String boX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.boW = aVar;
        this.boO = str;
        this.boX = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aG = this.boW.aG(this.boO, this.boX);
        if (aG == null) {
            return false;
        }
        return Boolean.valueOf(aG.isAcceptNotify());
    }
}
