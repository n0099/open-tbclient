package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends m<Boolean> {
    private final /* synthetic */ String ccA;
    final /* synthetic */ c cfB;
    private final /* synthetic */ long cfC;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.cfB = cVar;
        this.cfq = str;
        this.ccA = str2;
        this.cfC = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        GroupSettingItemData aO = this.cfB.aO(this.cfq, this.ccA);
        if (aO != null && aO.isAlreadyApply()) {
            if (System.currentTimeMillis() - aO.getLastApplyTimeStamp() <= this.cfC) {
                return false;
            }
        }
        return true;
    }
}
