package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bpH;
    final /* synthetic */ a bpP;
    private final /* synthetic */ String bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bpP = aVar;
        this.bpH = str;
        this.bpQ = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aJ = this.bpP.aJ(this.bpH, this.bpQ);
        if (aJ == null) {
            return false;
        }
        return Boolean.valueOf(aJ.isAcceptNotify());
    }
}
