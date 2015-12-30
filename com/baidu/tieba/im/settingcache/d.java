package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends m<Boolean> {
    private final /* synthetic */ String bYg;
    private final /* synthetic */ String caQ;
    final /* synthetic */ c cbb;
    private final /* synthetic */ long cbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.cbb = cVar;
        this.caQ = str;
        this.bYg = str2;
        this.cbc = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        GroupSettingItemData aJ = this.cbb.aJ(this.caQ, this.bYg);
        if (aJ != null && aJ.isAlreadyApply()) {
            if (System.currentTimeMillis() - aJ.getLastApplyTimeStamp() <= this.cbc) {
                return false;
            }
        }
        return true;
    }
}
