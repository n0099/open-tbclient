package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.aq {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fv(String str) {
        boolean z;
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        int i = 1;
        z = this.aCV.aAG;
        if (z) {
            wVar = this.aCV.aBK;
            if (wVar != null) {
                wVar2 = this.aCV.aBK;
                if (wVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aCV.eB(i);
        }
        this.aCV.aAE = false;
        TbadkCoreApplication.m255getInst().resetPbRecorder();
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fw(String str) {
        boolean z;
        z = this.aCV.aAG;
        if (z && !TextUtils.isEmpty(str)) {
            this.aCV.showToast(str);
        }
        this.aCV.aAE = false;
    }
}
