package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends t<Boolean> {
    private final /* synthetic */ String dhW;
    private final /* synthetic */ String dkM;
    final /* synthetic */ c dkX;
    private final /* synthetic */ long dkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dkX = cVar;
        this.dkM = str;
        this.dhW = str2;
        this.dkY = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        GroupSettingItemData bh = this.dkX.bh(this.dkM, this.dhW);
        if (bh != null && bh.isAlreadyApply()) {
            if (System.currentTimeMillis() - bh.getLastApplyTimeStamp() <= this.dkY) {
                return false;
            }
        }
        return true;
    }
}
