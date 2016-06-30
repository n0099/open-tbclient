package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String cTr;
    private final /* synthetic */ String cWi;
    final /* synthetic */ c cWt;
    private final /* synthetic */ long cWu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.cWt = cVar;
        this.cWi = str;
        this.cTr = str2;
        this.cWu = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bf = this.cWt.bf(this.cWi, this.cTr);
        if (bf != null && bf.isAlreadyApply()) {
            if (System.currentTimeMillis() - bf.getLastApplyTimeStamp() <= this.cWu) {
                return false;
            }
        }
        return true;
    }
}
