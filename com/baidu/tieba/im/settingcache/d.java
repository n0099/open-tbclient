package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bhK;
    final /* synthetic */ c bnD;
    private final /* synthetic */ long bnE;
    private final /* synthetic */ String bns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bnD = cVar;
        this.bns = str;
        this.bhK = str2;
        this.bnE = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aD = this.bnD.aD(this.bns, this.bhK);
        if (aD != null && aD.isAlreadyApply()) {
            if (System.currentTimeMillis() - aD.getLastApplyTimeStamp() <= this.bnE) {
                return false;
            }
        }
        return true;
    }
}
