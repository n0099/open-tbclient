package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<Boolean> {
    private final /* synthetic */ String coc;
    private final /* synthetic */ String cqS;
    final /* synthetic */ c crd;
    private final /* synthetic */ long cre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.crd = cVar;
        this.cqS = str;
        this.coc = str2;
        this.cre = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        GroupSettingItemData bf = this.crd.bf(this.cqS, this.coc);
        if (bf != null && bf.isAlreadyApply()) {
            if (System.currentTimeMillis() - bf.getLastApplyTimeStamp() <= this.cre) {
                return false;
            }
        }
        return true;
    }
}
