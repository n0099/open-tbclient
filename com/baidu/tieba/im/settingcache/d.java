package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bje;
    private final /* synthetic */ String boO;
    final /* synthetic */ c boZ;
    private final /* synthetic */ long bpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.boZ = cVar;
        this.boO = str;
        this.bje = str2;
        this.bpa = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aG = this.boZ.aG(this.boO, this.bje);
        if (aG != null && aG.isAlreadyApply()) {
            if (System.currentTimeMillis() - aG.getLastApplyTimeStamp() <= this.bpa) {
                return false;
            }
        }
        return true;
    }
}
