package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String aNZ;
    private final /* synthetic */ long bbA;
    final /* synthetic */ z bby;
    private final /* synthetic */ String bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str, String str2, long j) {
        this.bby = zVar;
        this.aNZ = str;
        this.bbz = str2;
        this.bbA = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        GroupSettingItemData am = this.bby.am(this.aNZ, this.bbz);
        if (am != null && am.isAlreadyApply()) {
            if (System.currentTimeMillis() - am.getLastApplyTimeStamp() <= this.bbA) {
                return false;
            }
        }
        return true;
    }
}
