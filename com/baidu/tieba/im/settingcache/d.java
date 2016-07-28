package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends t<Boolean> {
    private final /* synthetic */ String cWm;
    private final /* synthetic */ String cZd;
    final /* synthetic */ c cZo;
    private final /* synthetic */ long cZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.cZo = cVar;
        this.cZd = str;
        this.cWm = str2;
        this.cZp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        GroupSettingItemData bg = this.cZo.bg(this.cZd, this.cWm);
        if (bg != null && bg.isAlreadyApply()) {
            if (System.currentTimeMillis() - bg.getLastApplyTimeStamp() <= this.cZp) {
                return false;
            }
        }
        return true;
    }
}
