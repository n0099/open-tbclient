package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bpI;
    final /* synthetic */ a bpQ;
    private final /* synthetic */ String bpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bpQ = aVar;
        this.bpI = str;
        this.bpR = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aJ = this.bpQ.aJ(this.bpI, this.bpR);
        if (aJ == null) {
            return false;
        }
        return Boolean.valueOf(aJ.isAcceptNotify());
    }
}
