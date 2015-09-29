package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ String bEF;
    private final /* synthetic */ String bHf;
    final /* synthetic */ c bHq;
    private final /* synthetic */ long bHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bHq = cVar;
        this.bHf = str;
        this.bEF = str2;
        this.bHr = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        GroupSettingItemData aK = this.bHq.aK(this.bHf, this.bEF);
        if (aK != null && aK.isAlreadyApply()) {
            if (System.currentTimeMillis() - aK.getLastApplyTimeStamp() <= this.bHr) {
                return false;
            }
        }
        return true;
    }
}
