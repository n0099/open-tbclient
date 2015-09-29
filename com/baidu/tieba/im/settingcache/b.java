package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ String bHf;
    final /* synthetic */ a bHn;
    private final /* synthetic */ String bHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bHn = aVar;
        this.bHf = str;
        this.bHo = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aK = this.bHn.aK(this.bHf, this.bHo);
        if (aK == null) {
            return false;
        }
        return Boolean.valueOf(aK.isAcceptNotify());
    }
}
