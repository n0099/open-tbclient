package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class b extends t<Boolean> {
    private final /* synthetic */ String dmj;
    final /* synthetic */ a dmr;
    private final /* synthetic */ String dms;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.dmr = aVar;
        this.dmj = str;
        this.dms = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bj = this.dmr.bj(this.dmj, this.dms);
        if (bj == null) {
            return false;
        }
        return Boolean.valueOf(bj.isAcceptNotify());
    }
}
