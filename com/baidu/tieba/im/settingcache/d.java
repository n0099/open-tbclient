package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String dbV;
    private final /* synthetic */ String deO;
    final /* synthetic */ c deZ;
    private final /* synthetic */ long dfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.deZ = cVar;
        this.deO = str;
        this.dbV = str2;
        this.dfa = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bg = this.deZ.bg(this.deO, this.dbV);
        if (bg != null && bg.isAlreadyApply()) {
            if (System.currentTimeMillis() - bg.getLastApplyTimeStamp() <= this.dfa) {
                return false;
            }
        }
        return true;
    }
}
