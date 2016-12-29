package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String bDn;
    private final /* synthetic */ String cWN;
    final /* synthetic */ a cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.cWV = aVar;
        this.cWN = str;
        this.bDn = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bf = this.cWV.bf(this.cWN, this.bDn);
        if (bf == null) {
            return false;
        }
        return Boolean.valueOf(bf.isAcceptNotify());
    }
}
