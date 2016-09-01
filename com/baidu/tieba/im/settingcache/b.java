package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class b extends t<Boolean> {
    private final /* synthetic */ String dkM;
    final /* synthetic */ a dkU;
    private final /* synthetic */ String dkV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.dkU = aVar;
        this.dkM = str;
        this.dkV = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bh = this.dkU.bh(this.dkM, this.dkV);
        if (bh == null) {
            return false;
        }
        return Boolean.valueOf(bh.isAcceptNotify());
    }
}
