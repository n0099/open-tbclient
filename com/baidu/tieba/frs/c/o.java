package com.baidu.tieba.frs.c;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ n aNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aNF = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        bf bfVar;
        boolean isShowSwipeBackGuide = TbadkCoreApplication.m411getInst().isShowSwipeBackGuide();
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean(FrsActivity.aIF, false);
        if (isShowSwipeBackGuide && loadBoolean) {
            frsActivity = this.aNF.aNb;
            if (!frsActivity.isMenuShowing()) {
                TbadkCoreApplication.m411getInst().setShowSwipeBackGuide(false);
                bfVar = this.aNF.aIS;
                bfVar.Ko();
            }
        }
    }
}
