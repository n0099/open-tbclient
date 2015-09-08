package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bBB;
    private final /* synthetic */ String bEc;
    final /* synthetic */ c bEn;
    private final /* synthetic */ long bEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bEn = cVar;
        this.bEc = str;
        this.bBB = str2;
        this.bEo = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aL = this.bEn.aL(this.bEc, this.bBB);
        if (aL != null && aL.isAlreadyApply()) {
            if (System.currentTimeMillis() - aL.getLastApplyTimeStamp() <= this.bEo) {
                return false;
            }
        }
        return true;
    }
}
