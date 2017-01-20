package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String dbh;
    private final /* synthetic */ String ddZ;
    final /* synthetic */ c dek;
    private final /* synthetic */ long del;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dek = cVar;
        this.ddZ = str;
        this.dbh = str2;
        this.del = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bk = this.dek.bk(this.ddZ, this.dbh);
        if (bk != null && bk.isAlreadyApply()) {
            if (System.currentTimeMillis() - bk.getLastApplyTimeStamp() <= this.del) {
                return false;
            }
        }
        return true;
    }
}
