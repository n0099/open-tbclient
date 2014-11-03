package com.baidu.tieba.frs;

import android.text.TextUtils;
/* loaded from: classes.dex */
class o implements dh {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void fa(String str) {
        boolean z;
        com.baidu.tbadk.core.data.q qVar;
        com.baidu.tbadk.core.data.q qVar2;
        int i = 1;
        z = this.aBu.ayE;
        if (z) {
            qVar = this.aBu.aAs;
            if (qVar != null) {
                qVar2 = this.aBu.aAs;
                if (qVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aBu.eD(i);
        }
        this.aBu.ayC = false;
        com.baidu.tieba.pb.main.bs.Xc().reset();
    }

    @Override // com.baidu.tieba.frs.dh
    public void fb(String str) {
        boolean z;
        z = this.aBu.ayE;
        if (z && !TextUtils.isEmpty(str)) {
            this.aBu.showToast(str);
        }
        this.aBu.ayC = false;
    }
}
