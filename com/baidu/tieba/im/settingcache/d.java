package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bni;
    private final /* synthetic */ String bpI;
    final /* synthetic */ c bpT;
    private final /* synthetic */ long bpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bpT = cVar;
        this.bpI = str;
        this.bni = str2;
        this.bpU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aJ = this.bpT.aJ(this.bpI, this.bni);
        if (aJ != null && aJ.isAlreadyApply()) {
            if (System.currentTimeMillis() - aJ.getLastApplyTimeStamp() <= this.bpU) {
                return false;
            }
        }
        return true;
    }
}
