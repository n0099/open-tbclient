package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ String bEQ;
    final /* synthetic */ c bHB;
    private final /* synthetic */ long bHC;
    private final /* synthetic */ String bHq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bHB = cVar;
        this.bHq = str;
        this.bEQ = str2;
        this.bHC = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        GroupSettingItemData aK = this.bHB.aK(this.bHq, this.bEQ);
        if (aK != null && aK.isAlreadyApply()) {
            if (System.currentTimeMillis() - aK.getLastApplyTimeStamp() <= this.bHC) {
                return false;
            }
        }
        return true;
    }
}
