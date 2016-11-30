package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    private final /* synthetic */ String bXd;
    private final /* synthetic */ String drT;
    final /* synthetic */ a dsb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, String str2) {
        this.dsb = aVar;
        this.drT = str;
        this.bXd = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        com.baidu.tieba.im.pushNotify.a bj = this.dsb.bj(this.drT, this.bXd);
        if (bj == null) {
            return false;
        }
        return Boolean.valueOf(bj.isAcceptNotify());
    }
}
