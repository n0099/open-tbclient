package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String dpc;
    private final /* synthetic */ String drT;
    final /* synthetic */ c dsd;
    private final /* synthetic */ long dse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dsd = cVar;
        this.drT = str;
        this.dpc = str2;
        this.dse = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bj = this.dsd.bj(this.drT, this.dpc);
        if (bj != null && bj.isAlreadyApply()) {
            if (System.currentTimeMillis() - bj.getLastApplyTimeStamp() <= this.dse) {
                return false;
            }
        }
        return true;
    }
}
