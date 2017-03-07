package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String ddA;
    final /* synthetic */ c dgC;
    private final /* synthetic */ long dgD;
    private final /* synthetic */ String dgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dgC = cVar;
        this.dgr = str;
        this.ddA = str2;
        this.dgD = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bc = this.dgC.bc(this.dgr, this.ddA);
        if (bc != null && bc.isAlreadyApply()) {
            if (System.currentTimeMillis() - bc.getLastApplyTimeStamp() <= this.dgD) {
                return false;
            }
        }
        return true;
    }
}
