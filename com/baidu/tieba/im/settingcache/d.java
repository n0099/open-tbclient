package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bkm;
    private final /* synthetic */ String bmM;
    final /* synthetic */ c bmX;
    private final /* synthetic */ long bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bmX = cVar;
        this.bmM = str;
        this.bkm = str2;
        this.bmY = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aE = this.bmX.aE(this.bmM, this.bkm);
        if (aE != null && aE.isAlreadyApply()) {
            if (System.currentTimeMillis() - aE.getLastApplyTimeStamp() <= this.bmY) {
                return false;
            }
        }
        return true;
    }
}
