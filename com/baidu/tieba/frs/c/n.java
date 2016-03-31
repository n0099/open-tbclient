package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.frs.FrsActivity;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements SlidingMenu.OnClosedListener {
    final /* synthetic */ l buT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.buT = lVar;
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
        frsActivity = this.buT.bts;
        if (!TextUtils.isEmpty(frsActivity.getFrom())) {
            frsActivity4 = this.buT.bts;
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(frsActivity4.getFrom())) {
                frsActivity5 = this.buT.bts;
                frsActivity5.setSwipeBackEnabled(false);
                if (!this.buT.TW().Sz()) {
                    this.buT.TW().cJ(false);
                    frsActivity3 = this.buT.bts;
                    frsActivity3.refresh();
                    return;
                }
                return;
            }
        }
        frsActivity2 = this.buT.bts;
        frsActivity2.setSwipeBackEnabled(true);
        if (!this.buT.TW().Sz()) {
        }
    }
}
