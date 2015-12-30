package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.frs.FrsActivity;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements SlidingMenu.OnClosedListener {
    final /* synthetic */ l bnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bnd = lVar;
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
        frsActivity = this.bnd.blE;
        if (!TextUtils.isEmpty(frsActivity.getFrom())) {
            frsActivity4 = this.bnd.blE;
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(frsActivity4.getFrom())) {
                frsActivity5 = this.bnd.blE;
                frsActivity5.setSwipeBackEnabled(false);
                if (!this.bnd.Qd().OE()) {
                    this.bnd.Qd().cx(false);
                    frsActivity3 = this.bnd.blE;
                    frsActivity3.refresh();
                    return;
                }
                return;
            }
        }
        frsActivity2 = this.bnd.blE;
        frsActivity2.setSwipeBackEnabled(true);
        if (!this.bnd.Qd().OE()) {
        }
    }
}
