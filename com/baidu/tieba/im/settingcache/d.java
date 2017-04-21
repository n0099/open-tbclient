package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String deo;
    private final /* synthetic */ String dhf;
    final /* synthetic */ c dhq;
    private final /* synthetic */ long dhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dhq = cVar;
        this.dhf = str;
        this.deo = str2;
        this.dhr = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bf = this.dhq.bf(this.dhf, this.deo);
        if (bf != null && bf.isAlreadyApply()) {
            if (System.currentTimeMillis() - bf.getLastApplyTimeStamp() <= this.dhr) {
                return false;
            }
        }
        return true;
    }
}
