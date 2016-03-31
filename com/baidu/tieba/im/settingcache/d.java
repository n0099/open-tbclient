package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends p<Boolean> {
    private final /* synthetic */ String cnf;
    private final /* synthetic */ String cpV;
    final /* synthetic */ c cqg;
    private final /* synthetic */ long cqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.cqg = cVar;
        this.cpV = str;
        this.cnf = str2;
        this.cqh = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        GroupSettingItemData bb = this.cqg.bb(this.cpV, this.cnf);
        if (bb != null && bb.isAlreadyApply()) {
            if (System.currentTimeMillis() - bb.getLastApplyTimeStamp() <= this.cqh) {
                return false;
            }
        }
        return true;
    }
}
