package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends v<Boolean> {
    private final /* synthetic */ String cYo;
    private final /* synthetic */ String dbg;
    final /* synthetic */ c dbr;
    private final /* synthetic */ long dbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, long j) {
        this.dbr = cVar;
        this.dbg = str;
        this.cYo = str2;
        this.dbs = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        GroupSettingItemData bf = this.dbr.bf(this.dbg, this.cYo);
        if (bf != null && bf.isAlreadyApply()) {
            if (System.currentTimeMillis() - bf.getLastApplyTimeStamp() <= this.dbs) {
                return false;
            }
        }
        return true;
    }
}
