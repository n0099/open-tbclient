package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ String bFl;
    private final /* synthetic */ String bHL;
    final /* synthetic */ c bHW;
    private final /* synthetic */ long bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bHW = cVar;
        this.bHL = str;
        this.bFl = str2;
        this.bHX = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        GroupSettingItemData aJ = this.bHW.aJ(this.bHL, this.bFl);
        if (aJ != null && aJ.isAlreadyApply()) {
            if (System.currentTimeMillis() - aJ.getLastApplyTimeStamp() <= this.bHX) {
                return false;
            }
        }
        return true;
    }
}
