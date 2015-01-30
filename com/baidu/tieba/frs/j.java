package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.aq {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fA(String str) {
        boolean z;
        com.baidu.tbadk.core.data.x xVar;
        com.baidu.tbadk.core.data.x xVar2;
        int i = 1;
        z = this.aDW.aBI;
        if (z) {
            xVar = this.aDW.aCL;
            if (xVar != null) {
                xVar2 = this.aDW.aCL;
                if (xVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aDW.eH(i);
        }
        this.aDW.aBG = false;
        TbadkCoreApplication.m255getInst().resetPbRecorder();
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fB(String str) {
        boolean z;
        z = this.aDW.aBI;
        if (z && !TextUtils.isEmpty(str)) {
            this.aDW.showToast(str);
        }
        this.aDW.aBG = false;
    }
}
