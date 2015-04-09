package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bkC;
    private final /* synthetic */ String bnc;
    final /* synthetic */ c bnn;
    private final /* synthetic */ long bno;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bnn = cVar;
        this.bnc = str;
        this.bkC = str2;
        this.bno = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aE = this.bnn.aE(this.bnc, this.bkC);
        if (aE != null && aE.isAlreadyApply()) {
            if (System.currentTimeMillis() - aE.getLastApplyTimeStamp() <= this.bno) {
                return false;
            }
        }
        return true;
    }
}
