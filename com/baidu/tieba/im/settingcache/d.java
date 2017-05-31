package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends v<Boolean> {
    private final /* synthetic */ String ddO;
    private final /* synthetic */ String dgD;
    final /* synthetic */ c dgO;
    private final /* synthetic */ long dgP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dgO = cVar;
        this.dgD = str;
        this.ddO = str2;
        this.dgP = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        GroupSettingItemData bd = this.dgO.bd(this.dgD, this.ddO);
        if (bd != null && bd.isAlreadyApply()) {
            if (System.currentTimeMillis() - bd.getLastApplyTimeStamp() <= this.dgP) {
                return false;
            }
        }
        return true;
    }
}
