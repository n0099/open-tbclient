package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.p;
/* loaded from: classes.dex */
class b extends p<Boolean> {
    private final /* synthetic */ String cpV;
    final /* synthetic */ a cqd;
    private final /* synthetic */ String cqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.cqd = aVar;
        this.cpV = str;
        this.cqe = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bb = this.cqd.bb(this.cpV, this.cqe);
        if (bb == null) {
            return false;
        }
        return Boolean.valueOf(bb.isAcceptNotify());
    }
}
