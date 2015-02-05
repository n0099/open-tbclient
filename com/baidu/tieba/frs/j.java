package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.aq {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fx(String str) {
        boolean z;
        com.baidu.tbadk.core.data.x xVar;
        com.baidu.tbadk.core.data.x xVar2;
        int i = 1;
        z = this.aDT.aBF;
        if (z) {
            xVar = this.aDT.aCI;
            if (xVar != null) {
                xVar2 = this.aDT.aCI;
                if (xVar2.getPraise().getIsLike() == 1) {
                    i = 0;
                }
            }
            this.aDT.eH(i);
        }
        this.aDT.aBD = false;
        TbadkCoreApplication.m255getInst().resetPbRecorder();
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fy(String str) {
        boolean z;
        z = this.aDT.aBF;
        if (z && !TextUtils.isEmpty(str)) {
            this.aDT.showToast(str);
        }
        this.aDT.aBD = false;
    }
}
