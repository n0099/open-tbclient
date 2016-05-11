package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String cqS;
    final /* synthetic */ a cra;
    private final /* synthetic */ String crb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.cra = aVar;
        this.cqS = str;
        this.crb = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bf = this.cra.bf(this.cqS, this.crb);
        if (bf == null) {
            return false;
        }
        return Boolean.valueOf(bf.isAcceptNotify());
    }
}
