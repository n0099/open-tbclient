package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String cTX;
    private final /* synthetic */ String cWN;
    final /* synthetic */ c cWX;
    private final /* synthetic */ long cWY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.cWX = cVar;
        this.cWN = str;
        this.cTX = str2;
        this.cWY = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bf = this.cWX.bf(this.cWN, this.cTX);
        if (bf != null && bf.isAlreadyApply()) {
            if (System.currentTimeMillis() - bf.getLastApplyTimeStamp() <= this.cWY) {
                return false;
            }
        }
        return true;
    }
}
