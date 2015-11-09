package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class b extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ String bHL;
    final /* synthetic */ a bHT;
    private final /* synthetic */ String bHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.bHT = aVar;
        this.bHL = str;
        this.bHU = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a aJ = this.bHT.aJ(this.bHL, this.bHU);
        if (aJ == null) {
            return false;
        }
        return Boolean.valueOf(aJ.isAcceptNotify());
    }
}
