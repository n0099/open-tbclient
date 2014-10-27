package com.baidu.tieba.frs;

import android.text.TextUtils;
/* loaded from: classes.dex */
class o implements dh {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void fa(String str) {
        boolean z;
        com.baidu.tbadk.core.data.q qVar;
        com.baidu.tbadk.core.data.q qVar2;
        int i = 1;
        z = this.aBk.ayv;
        if (z) {
            qVar = this.aBk.aAi;
            if (qVar != null) {
                qVar2 = this.aBk.aAi;
                if (qVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aBk.eD(i);
        }
        this.aBk.ayt = false;
        com.baidu.tieba.pb.main.bs.WZ().reset();
    }

    @Override // com.baidu.tieba.frs.dh
    public void fb(String str) {
        boolean z;
        z = this.aBk.ayv;
        if (z && !TextUtils.isEmpty(str)) {
            this.aBk.showToast(str);
        }
        this.aBk.ayt = false;
    }
}
