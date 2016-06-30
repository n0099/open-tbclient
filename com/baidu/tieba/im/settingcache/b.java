package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String cWi;
    final /* synthetic */ a cWq;
    private final /* synthetic */ String cWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.cWq = aVar;
        this.cWi = str;
        this.cWr = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bf = this.cWq.bf(this.cWi, this.cWr);
        if (bf == null) {
            return false;
        }
        return Boolean.valueOf(bf.isAcceptNotify());
    }
}
