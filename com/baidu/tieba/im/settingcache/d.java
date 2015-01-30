package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bjf;
    private final /* synthetic */ String boP;
    final /* synthetic */ c bpa;
    private final /* synthetic */ long bpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bpa = cVar;
        this.boP = str;
        this.bjf = str2;
        this.bpb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aG = this.bpa.aG(this.boP, this.bjf);
        if (aG != null && aG.isAlreadyApply()) {
            if (System.currentTimeMillis() - aG.getLastApplyTimeStamp() <= this.bpb) {
                return false;
            }
        }
        return true;
    }
}
