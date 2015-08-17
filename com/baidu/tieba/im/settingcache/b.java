package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ a bDD;
    private final /* synthetic */ String bDE;
    private final /* synthetic */ String bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bDD = aVar;
        this.bDv = str;
        this.bDE = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aJ = this.bDD.aJ(this.bDv, this.bDE);
        if (aJ == null) {
            return false;
        }
        return Boolean.valueOf(aJ.isAcceptNotify());
    }
}
