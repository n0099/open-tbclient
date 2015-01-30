package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String boP;
    final /* synthetic */ a boX;
    private final /* synthetic */ String boY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.boX = aVar;
        this.boP = str;
        this.boY = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aG = this.boX.aG(this.boP, this.boY);
        if (aG == null) {
            return false;
        }
        return Boolean.valueOf(aG.isAcceptNotify());
    }
}
