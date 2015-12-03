package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends m<Boolean> {
    private final /* synthetic */ String bUs;
    private final /* synthetic */ String bWR;
    final /* synthetic */ c bXc;
    private final /* synthetic */ long bXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.bXc = cVar;
        this.bWR = str;
        this.bUs = str2;
        this.bXd = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        GroupSettingItemData aO = this.bXc.aO(this.bWR, this.bUs);
        if (aO != null && aO.isAlreadyApply()) {
            if (System.currentTimeMillis() - aO.getLastApplyTimeStamp() <= this.bXd) {
                return false;
            }
        }
        return true;
    }
}
