package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bnh;
    private final /* synthetic */ String bpH;
    final /* synthetic */ c bpS;
    private final /* synthetic */ long bpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bpS = cVar;
        this.bpH = str;
        this.bnh = str2;
        this.bpT = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aJ = this.bpS.aJ(this.bpH, this.bnh);
        if (aJ != null && aJ.isAlreadyApply()) {
            if (System.currentTimeMillis() - aJ.getLastApplyTimeStamp() <= this.bpT) {
                return false;
            }
        }
        return true;
    }
}
