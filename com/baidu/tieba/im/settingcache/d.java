package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends t<Boolean> {
    private final /* synthetic */ String djt;
    private final /* synthetic */ String dmj;
    final /* synthetic */ c dmu;
    private final /* synthetic */ long dmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dmu = cVar;
        this.dmj = str;
        this.djt = str2;
        this.dmv = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        GroupSettingItemData bj = this.dmu.bj(this.dmj, this.djt);
        if (bj != null && bj.isAlreadyApply()) {
            if (System.currentTimeMillis() - bj.getLastApplyTimeStamp() <= this.dmv) {
                return false;
            }
        }
        return true;
    }
}
