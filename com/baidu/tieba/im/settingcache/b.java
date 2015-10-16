package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ String bHq;
    final /* synthetic */ a bHy;
    private final /* synthetic */ String bHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bHy = aVar;
        this.bHq = str;
        this.bHz = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aK = this.bHy.aK(this.bHq, this.bHz);
        if (aK == null) {
            return false;
        }
        return Boolean.valueOf(aK.isAcceptNotify());
    }
}
