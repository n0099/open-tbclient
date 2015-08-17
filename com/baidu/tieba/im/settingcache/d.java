package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ String bAU;
    final /* synthetic */ c bDG;
    private final /* synthetic */ long bDH;
    private final /* synthetic */ String bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bDG = cVar;
        this.bDv = str;
        this.bAU = str2;
        this.bDH = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        GroupSettingItemData aJ = this.bDG.aJ(this.bDv, this.bAU);
        if (aJ != null && aJ.isAlreadyApply()) {
            if (System.currentTimeMillis() - aJ.getLastApplyTimeStamp() <= this.bDH) {
                return false;
            }
        }
        return true;
    }
}
