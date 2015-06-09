package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.frs.FrsActivity;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements SlidingMenu.OnClosedListener {
    final /* synthetic */ k aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.aQh = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClosed() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        frsActivity = this.aQh.aPF;
        if (!TextUtils.isEmpty(frsActivity.getFrom())) {
            frsActivity4 = this.aQh.aPF;
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(frsActivity4.getFrom())) {
                frsActivity5 = this.aQh.aPF;
                frsActivity5.setSwipeBackEnabled(false);
                if (!this.aQh.Mz().LN()) {
                    this.aQh.Mz().ce(false);
                    frsActivity3 = this.aQh.aPF;
                    frsActivity3.refresh();
                    return;
                }
                return;
            }
        }
        frsActivity2 = this.aQh.aPF;
        frsActivity2.setSwipeBackEnabled(true);
        if (!this.aQh.Mz().LN()) {
        }
    }
}
