package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends w<Boolean> {
    private final /* synthetic */ String dlK;
    final /* synthetic */ c doK;
    private final /* synthetic */ long doL;
    private final /* synthetic */ String doz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.doK = cVar;
        this.doz = str;
        this.dlK = str2;
        this.doL = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        GroupSettingItemData bk = this.doK.bk(this.doz, this.dlK);
        if (bk != null && bk.isAlreadyApply()) {
            if (System.currentTimeMillis() - bk.getLastApplyTimeStamp() <= this.doL) {
                return false;
            }
        }
        return true;
    }
}
